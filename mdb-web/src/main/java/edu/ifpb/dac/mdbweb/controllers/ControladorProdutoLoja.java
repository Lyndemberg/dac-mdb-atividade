/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.mdbweb.controllers;

import edu.ifpb.dac.mdbshared.model.Produto;
import edu.ifpb.dac.mdbshared.service.ProdutoLojaDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author romulo
 */
@Named
@SessionScoped
public class ControladorProdutoLoja implements Serializable {

    private Produto produto;
    private List<Produto> produtos;
    @Inject
    private ProdutoLojaDao produtoLojaDao;

    public ControladorProdutoLoja() {
        this.produto = new Produto();
        this.produtos = new ArrayList<>();
    }

    public String addBanco() {
        for (Produto p : produtos) {
            if (!produtoLojaDao.isRegisteredProduct(p.getDescricao())) {
                produtoLojaDao.cadastrarProduto(p);
            }
        }
        produtos = new ArrayList<>();
        return null;
    }

    public String addList() {
        this.produtos.add(produto);
        this.produto = new Produto();
        return null;
    }

    public String removeList(Produto produto) {
        this.produtos.remove(produto);
        return null;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public ProdutoLojaDao getProdutoLojaDao() {
        return produtoLojaDao;
    }

    public void setProdutoLojaDao(ProdutoLojaDao produtoLojaDao) {
        this.produtoLojaDao = produtoLojaDao;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

}
