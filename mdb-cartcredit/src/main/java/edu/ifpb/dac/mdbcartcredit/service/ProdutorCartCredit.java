/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.mdbcartcredit.service;

import edu.ifpb.dac.mdbshared.model.RespostaProcessamento;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.Queue;

/**
 *
 * @author romulo
 */
@JMSDestinationDefinition(
        name = "java:global/jms/queueProcessamento",
        interfaceName = "javax.jms.Queue",
        resourceAdapter = "jmsra",
        destinationName = "queueProcessamento")

@Stateless
public class ProdutorCartCredit {
    
    @Resource(lookup = "java:global/jms/queueProcessamento")
    private Queue fila;

    @Inject
    private JMSContext context;

    public void enviar(RespostaProcessamento respostaProcessamento) {
        JMSProducer createProducer = context.createProducer();
        createProducer.send(fila, (Message) respostaProcessamento);
    }

}
