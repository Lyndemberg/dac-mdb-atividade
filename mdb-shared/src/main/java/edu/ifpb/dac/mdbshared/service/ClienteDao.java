/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.mdbshared.service;

import edu.ifpb.dac.mdbshared.model.Cliente;

/**
 *
 * @author romulo
 */
public interface ClienteDao {

    public void cadastrarCliente(Cliente cliente);

    public Cliente autenticarCliente(String email, String senha);

}
