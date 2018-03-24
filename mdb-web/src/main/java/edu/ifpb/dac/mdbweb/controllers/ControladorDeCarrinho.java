package edu.ifpb.dac.mdbweb.controllers;

import edu.ifpb.dac.mdbshared.model.Cliente;
import edu.ifpb.dac.mdbshared.model.Produto;
import edu.ifpb.dac.mdbshared.service.Carrinho;
import edu.ifpb.dac.mdbshared.service.ProdutoDao;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;

@Named
@SessionScoped
public class ControladorDeCarrinho implements Serializable {

    private Produto produto = new Produto();
    @Inject
    private Carrinho carrinho;
    @Inject
    private ProdutoDao produtoDao;
    private Cliente cliente;
    
    @PostConstruct
    public void init(){
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession sessao = (HttpSession) externalContext.getSession(false);
        cliente = (Cliente) sessao.getAttribute("cliente");
        this.carrinho.setCliente(cliente);
    }
    
    public String add() {
        Produto recuperado = produtoDao.buscarPorId(produto.getId());
        this.carrinho.adicionarProduto(recuperado);
        this.produto = new Produto();
        return null;
    }

    public String remove(Produto produto) {
        this.carrinho.removerProduto(produto);
        return null;
    }

    public String finalizarCompra() {
        
        this.carrinho.finalizarCompra();
        try {
            //QUANDO O @REMOVE DO STATEFUL É CHAMADO, 
            //É NECESSÁRIO OBTER UMA NOVA REFERÊNCIA DE OUTRO CARRINHO
            InitialContext cxt = new InitialContext();
            carrinho = (Carrinho) cxt.lookup("java:global/mdb-web/CarrinhoOnline");
            carrinho.setCliente(cliente);
        } catch (NamingException ex) {
            Logger.getLogger(ControladorDeCarrinho.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Produto> todosOsProdutos() {
        return this.carrinho.listarProdutos();
    }
    
    private void encerrarSessao() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        
        externalContext.invalidateSession();
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
