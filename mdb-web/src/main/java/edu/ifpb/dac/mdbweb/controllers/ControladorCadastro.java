
package edu.ifpb.dac.mdbweb.controllers;

import edu.ifpb.dac.mdbshared.model.Cliente;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author lyndemberg
 */
@Named
@RequestScoped
public class ControladorCadastro {
    private Cliente cliente = new Cliente();

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
}
