/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.mdbweb.daos;

import edu.ifpb.dac.mdbshared.model.Pedido;
import edu.ifpb.dac.mdbshared.service.PedidoDao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author romulo
 */
public class PedidoDaoImpl implements PedidoDao {

    @PersistenceContext(unitName = "mdb")
    EntityManager entityManager;

    @Override
    public void cadastrarPedido(Pedido pedido) {
        entityManager.persist(pedido);
    }

    @Override
    public void removerPedido(Pedido pedido) {
        entityManager.remove(pedido);
    }

    @Override
    public void atualizarPedido(Pedido novoEstado) {
        entityManager.merge(novoEstado);
    }

}
