/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.mdbweb.daos;

import edu.ifpb.dac.mdbshared.model.Produto;
import edu.ifpb.dac.mdbshared.service.ProdutoDao;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author romulo
 */
@Stateless
@Local(ProdutoDao.class)
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

    @Override
    public Produto buscarPorId(int id) {
        Produto produto = entityManager.find(Produto.class, id);
        return produto;
    }

}
