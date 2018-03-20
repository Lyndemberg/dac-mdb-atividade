
package edu.ifpb.dac.mdbweb.controllers;

import edu.ifpb.dac.mdbshared.model.Cliente;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author lyndemberg
 */
@Named
@RequestScoped
public class ControladorCliente {
    private Cliente cliente = new Cliente();
    
    public String logar(){
        return null;
    }

    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml?faces-redirect=true";
    }
    
    private void mostrarMsg(String titulo, String corpo){
        FacesMessage mensagem = new FacesMessage(corpo);
        mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(titulo, mensagem);
    }   

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
}
