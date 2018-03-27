package edu.ifpb.dac.mdbemail.consumers;

import edu.ifpb.dac.mdbemail.infra.EnviarEmail;
import edu.ifpb.dac.mdbshared.model.RespostaProcessamento;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author lyndemberg
 */
@MessageDriven(
        mappedName = "jms/queueProcessamento",
        activationConfig = {
            @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
            @ActivationConfigProperty(propertyName = "destinationName", propertyValue = "queueProcessamento"),
        }
)

@Stateless
public class ConsumerProcessamento implements MessageListener{
    @Inject
    private EnviarEmail sender;
    
    @Override
    public void onMessage(Message message) {
        try {
            RespostaProcessamento resposta = message.getBody(RespostaProcessamento.class);
            sender.sendProcessamento(resposta);
        } catch (JMSException ex) {
            Logger.getLogger(ConsumerProcessamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
