
package edu.ifpb.dac.mdbweb.jms.service;

import edu.ifpb.dac.mdbshared.model.Pedido;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSProducer;
import javax.jms.Topic;

/**
 *
 * @author lyndemberg
 */

@JMSDestinationDefinition(
        name = "java:global/jms/TopicFinalizacao",
        interfaceName = "javax.jms.Topic",
        resourceAdapter = "jmsra",
        destinationName = "TopicFinalizacao"
)
@Stateless
public class EnviarFinalizacao {
    @Resource(lookup = "java:global/jms/TopicFinalizacao")
    private Topic topico;
    @Inject
    private JMSContext context;
    
    public void enviar(Pedido p){
        JMSProducer produtor = context.createProducer();
        produtor.send(topico,p);
        System.out.println("Pedido enviado para o tópico de finalização");
    }
}
