/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.mdbshared.service;

import edu.ifpb.dac.mdbshared.model.Produto;
import java.util.List;

/**
 *
 * @author romulo
 */
public interface ProdutoDao {

    public List<Produto> getListProducts();

}
