package edu.ifpb.dac.mdbweb.jms.service;

import edu.ifpb.dac.mdbshared.model.Cliente;
import edu.ifpb.dac.mdbshared.model.Pedido;
import edu.ifpb.dac.mdbshared.model.Produto;
import edu.ifpb.dac.mdbshared.service.Carrinho;
import java.util.Collections;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
@Remote(Carrinho.class)
public class CarrinhoOnline implements Carrinho {
    
    private final Pedido pedido = new Pedido();
    
    @Override
    public void adicionarProduto(Produto produto) {
        this.pedido.add(produto);
    }
    
    @Override
    public void removerProduto(Produto produto) {
        this.pedido.remove(produto);
    }
    
    @Override
    public List<Produto> listarProdutos() {
        return Collections.unmodifiableList(pedido.getProdutos());
    }
    
    @Override
    public void setCliente(Cliente cliente) {
        this.pedido.setCliente(cliente);
    }
    
    @Remove
    @Override
    public void finalizarCompra() {
        new EnviarFinalizacao().enviar(pedido);
    }
    
}
