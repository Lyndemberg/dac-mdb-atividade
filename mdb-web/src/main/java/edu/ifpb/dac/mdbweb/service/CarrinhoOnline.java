package edu.ifpb.dac.mdbweb.service;

import edu.ifpb.dac.mdbshared.model.Cliente;
import edu.ifpb.dac.mdbshared.model.Pedido;
import edu.ifpb.dac.mdbshared.model.Produto;
import edu.ifpb.dac.mdbshared.service.Carrinho;
import edu.ifpb.dac.mdbweb.jms.service.EnviarFinalizacao;
import java.util.Collections;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.inject.Inject;

@Stateful
@Local(Carrinho.class)
public class CarrinhoOnline implements Carrinho {
    
    @Inject
    private EnviarFinalizacao finalizacao;
    
    private final Pedido pedido;
    
    public CarrinhoOnline(){
        pedido = new Pedido();
    }
    
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
        finalizacao.enviar(pedido);
    }
    
}
