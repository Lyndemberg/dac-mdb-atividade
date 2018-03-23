
package edu.ifpb.dac.mdbweb.controllers;

import edu.ifpb.dac.mdbshared.model.Cliente;
import edu.ifpb.dac.mdbshared.service.ClienteDao;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lyndemberg
 */
@Named
@RequestScoped
public class ControladorCliente {
    private Cliente cliente = new Cliente();
    @Inject
    private ClienteDao clienteDao;
    
    public String logar(){
        if(!clienteDao.clienteExiste(cliente.getEmail())){
            mostrarMsg("Login", "Esse usuário não foi cadastrado");
            return null;
        }else{
            Cliente cli = clienteDao.autenticarCliente(cliente.getEmail(), cliente.getSenha());
            if(cli == null){
                mostrarMsg("Login", "Dados incorretos");
                return null;
            }else{
                 HttpSession sessao = (HttpSession) 
                         FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                 sessao.setAttribute("cliente", cli);
                 return "home.xhtml?faces-redirect=true";
            }
        }
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
