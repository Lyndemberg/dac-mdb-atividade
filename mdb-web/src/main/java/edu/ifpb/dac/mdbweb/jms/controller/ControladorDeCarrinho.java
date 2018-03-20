package edu.ifpb.dac.mdbweb.jms.controller;

import edu.ifpb.dac.mdbshared.model.Cliente;
import edu.ifpb.dac.mdbshared.model.Produto;
import edu.ifpb.dac.mdbshared.service.Carrinho;
import edu.ifpb.dac.mdbweb.jms.service.CarrinhoOnline;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named
@SessionScoped
public class ControladorDeCarrinho implements Serializable {

    private Produto produto;

    private Carrinho carrinho;

    @PostConstruct
    public void init() {
        this.carrinho = new CarrinhoOnline();
        this.produto = new Produto();
    }
    
    public String add() {
        this.carrinho.adicionarProduto(produto);
        this.produto = new Produto();
        return null;
    }

    public String remove(Produto produto) {
        this.carrinho.removerProduto(produto);
        return null;
    }

    public String finalizarCompra() {
        this.carrinho.finalizarCompra();
        encerrarSessao();
        return "home.xhtml?faces-redirect=true";
    }

    public List<Produto> todosOsProdutos() {
        return this.carrinho.listarProdutos();
    }
    
    public void setCliente(Cliente cliente){
        this.carrinho.setCliente(cliente);
    }
    
    private void encerrarSessao() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(true);
        if (session != null) {
            session.invalidate();
        }
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

}
