/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.mdbshared.service;

import edu.ifpb.dac.mdbshared.model.Produto;

/**
 *
 * @author romulo
 */
public interface ProdutoLojaDao {

    public void cadastrarProduto(Produto produto);

    public boolean isRegisteredProduct(String descricao);

//    public void removerProduto(Produto Produto);

}
