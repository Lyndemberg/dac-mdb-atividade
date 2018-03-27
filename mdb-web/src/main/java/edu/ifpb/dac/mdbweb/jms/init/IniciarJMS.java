/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.mdbweb.jms.init;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;

/**
 *
 * @author lyndemberg
 */
//@JMSDestinationDefinitions(value = {
//    @JMSDestinationDefinition(
//        name = "java:global/jms/TopicFinalizacao",
//        interfaceName = "javax.jms.Topic",
//        resourceAdapter = "jmsra",
//        destinationName = "TopicFinalizacao"
//    ),
//    @JMSDestinationDefinition(
//        name = "java:global/jms/queueProcessamento",
//        interfaceName = "javax.jms.Queue",
//        resourceAdapter = "jmsra",
//        destinationName = "queueProcessamento")
//
//})
@Singleton
@Startup
public class IniciarJMS {
    public IniciarJMS(){
        System.out.println("Criando todos os destinos JMS");
    }
}
