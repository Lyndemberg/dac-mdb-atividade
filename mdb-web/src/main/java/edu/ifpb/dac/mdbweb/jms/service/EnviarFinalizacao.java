
package edu.ifpb.dac.mdbweb.jms.service;

import edu.ifpb.dac.mdbshared.model.Pedido;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Topic;

/**
 *
 * @author lyndemberg
 */

@Stateless
public class EnviarFinalizacao {
    @Resource(lookup = "jms/TopicFinalizacao")
    private Topic topico;
    @Inject
    private JMSContext context;
    
    public void enviar(Pedido p){
        JMSProducer produtor = context.createProducer();
        produtor.send(topico,p);
        System.out.println("Pedido enviado para o tópico de finalização");
    }
}
