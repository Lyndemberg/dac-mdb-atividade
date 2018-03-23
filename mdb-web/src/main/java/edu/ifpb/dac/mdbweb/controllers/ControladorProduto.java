package edu.ifpb.dac.mdbweb.controllers;

import edu.ifpb.dac.mdbshared.model.Produto;
import edu.ifpb.dac.mdbshared.service.ProdutoDao;
import java.util.Collections;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author lyndemberg
 */
@Named
@RequestScoped
public class ControladorProduto {
    @Inject
    private ProdutoDao produtoDao;
    
    public List<Produto> listarTodos(){
        return Collections.unmodifiableList(produtoDao.getListProducts());
    }
    
}
