/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.mdbweb.daos;

import edu.ifpb.dac.mdbshared.model.Cliente;
import edu.ifpb.dac.mdbshared.model.Produto;
import edu.ifpb.dac.mdbshared.service.ProdutoDao;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author romulo
 */
public class ProdutoDaoImpl implements ProdutoDao {

    @PersistenceContext(unitName = "mdb")
    EntityManager entityManager;

    @Override
    public List<Produto> getListProducts() {
        String querySql = "SELECT p FROM Produto p ";
        TypedQuery<Produto> query = entityManager
                .createQuery(querySql, Produto.class);
        if (query.getResultList() == null) {
            return new ArrayList<>();
        }
        return query.getResultList();
    }

}
