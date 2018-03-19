package edu.ifpb.dac.mdbemail.consumers;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.Stateless;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author lyndemberg
 */
@MessageDriven(
        mappedName = "java:global/jms/queueProcessamento",
        activationConfig = {
            @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
            @ActivationConfigProperty(propertyName = "destinationName", propertyValue = "queueProcessamento"),
        }
)

@Stateless
public class ConsumerProcessamento implements MessageListener{

    @Override
    public void onMessage(Message message) {
        
    }

}
