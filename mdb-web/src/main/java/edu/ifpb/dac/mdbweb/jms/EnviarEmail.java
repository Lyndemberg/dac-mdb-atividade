
package edu.ifpb.dac.mdbweb.jms;

import edu.ifpb.dac.mdbshared.model.Pedido;
import javax.ejb.Stateless;
import javax.jms.JMSDestinationDefinition;

/**
 *
 * @author lyndemberg
 */

@JMSDestinationDefinition(
        name = "java:global/jms/TopicEmail",
        interfaceName = "javax.jms.Topic",
        resourceAdapter = "jmsra",
        destinationName = "topicoEmail"
)
@Stateless
public class EnviarEmail {
    public void enviar(Pedido p){
        
    }
}
