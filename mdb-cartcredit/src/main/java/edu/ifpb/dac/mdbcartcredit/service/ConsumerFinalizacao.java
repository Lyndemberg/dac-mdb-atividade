/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.mdbcartcredit.service;

import edu.ifpb.dac.mdbshared.model.CartCredit;
import edu.ifpb.dac.mdbshared.model.Pedido;
import edu.ifpb.dac.mdbshared.model.RespostaProcessamento;
import java.math.BigDecimal;
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
 * @author romulo
 */
@MessageDriven(
        mappedName = "java:global/jms/TopicFinalizacao",
        activationConfig = {
            @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
            ,
            @ActivationConfigProperty(propertyName = "destinationName", propertyValue = "TopicFinalizacao"),}
)

public class ConsumerFinalizacao implements MessageListener {
    
    @Inject
    private ProdutorCartCredit produtor;
    
    @Override
    public void onMessage(Message message) {
        try {
            Pedido pedido = message.getBody(Pedido.class);
            BigDecimal valorCompra = pedido.getValorTotal();
            RespostaProcessamento rp = new RespostaProcessamento(pedido.getId());
            
            if (new CartCredit().fazerPagamento(valorCompra)) {
                rp.setMensagem("Pagamento do Pedido Confirmado!");
            } else {
                rp.setMensagem("Não há saldo para o Pagamento!");
            }
            produtor.enviar(rp);
        } catch (JMSException ex) {
            Logger.getLogger(ConsumerFinalizacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
