
package edu.ifpb.dac.mdbemail.consumers;

import edu.ifpb.dac.mdbemail.infra.EnviarEmail;
import edu.ifpb.dac.mdbshared.model.Pedido;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author lyndemberg
 */
@MessageDriven(
        mappedName = "jms/TopicFinalizacao",
        activationConfig = {
            @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
            @ActivationConfigProperty(propertyName = "destinationName", propertyValue = "TopicFinalizacao"),
        }
)

public class ConsumerFinalizacao implements MessageListener{
    
    @Inject
    private EnviarEmail sender;
    
    @Override
    public void onMessage(Message message) {
        try {
            Pedido pedido = message.getBody(Pedido.class);
            sender.sendFinalizacao(pedido);
        } catch (JMSException ex) {
            Logger.getLogger(ConsumerFinalizacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
