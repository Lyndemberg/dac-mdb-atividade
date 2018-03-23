
package edu.ifpb.dac.mdbweb.controllers;

import edu.ifpb.dac.mdbshared.model.Cliente;
import edu.ifpb.dac.mdbshared.service.ClienteDao;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author lyndemberg
 */
@Named
@RequestScoped
public class ControladorCadastro {
    private Cliente cliente = new Cliente();
    @Inject
    private ClienteDao clienteDao;
    
    public String cadastrar(){
        if(clienteDao.clienteExiste(cliente.getEmail())){
            mostrarMsg("Cadastro", "Já existe um usuário cadastrado com esse email");
            return null;
        }else{
            clienteDao.cadastrarCliente(cliente);
            return "index.xhtml?faces-redirect=true";
        }
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    private void mostrarMsg(String titulo, String corpo){
        FacesMessage mensagem = new FacesMessage(corpo);
        mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(titulo, mensagem);
    }   
    
    
}
