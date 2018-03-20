package edu.ifpb.dac.mdbshared.service;

import edu.ifpb.dac.mdbshared.model.Cliente;
import edu.ifpb.dac.mdbshared.model.Produto;
import java.util.List;

public interface Carrinho {

    public void adicionarProduto(Produto produto);

    public void removerProduto(Produto produto);

    public List<Produto> listarProdutos();

    public void setCliente(Cliente cliente);

    public void finalizarCompra();

}
