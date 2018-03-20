/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.mdbshared.service;

import edu.ifpb.dac.mdbshared.model.Pedido;

/**
 *
 * @author romulo
 */
public interface PedidoDao {

    public void cadastrarPedido(Pedido pedido);

    public void removerPedido(Pedido pedido);

    public void atualizarPedido(Pedido novoEstado);

}
