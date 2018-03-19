package edu.ifpb.dac.mdbemail.infra;

import edu.ifpb.dac.mdbshared.model.Pedido;
import edu.ifpb.dac.mdbshared.model.RespostaProcessamento;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author lyndemberg
 */
@Stateless
public class EnviarEmail {
    private final String EMAIL = "projetodacq@gmail.com";
    private final String SENHA = "projetodac123";
    private final Email email = new SimpleEmail();
    
    @PostConstruct
    public void init(){
        email.setHostName("smtp.googlemail.com");
        email.setAuthenticator(new DefaultAuthenticator(EMAIL, SENHA));
        email.setTLS(true);
        email.setSSL(true);
    }
    
    public void sendFinalizacao(Pedido p){
        try {
            email.setFrom(EMAIL);
            email.addTo(p.getCliente().getEmail());
            email.setMsg("Pedido finalizado, veja os dados:"
            + "Código->" + p.getId() + "Produto(s)->" + p.getProdutos().toString()
            );      
            email.send();
        } catch (EmailException ex) {
            Logger.getLogger(EnviarEmail.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    public void sendProcessamento(RespostaProcessamento resposta){
        try {
            email.setFrom(EMAIL);
            email.addTo(resposta.getEmailUser());
            email.setMsg("Seu pedido com código: " + resposta.getCodPedido() + " foi processado. "
                    + "Veja o resultado: "+resposta.getMensagem());      
            email.send();
        } catch (EmailException ex) {
            Logger.getLogger(EnviarEmail.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    
}
