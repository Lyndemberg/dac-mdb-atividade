/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.mdbweb.daos;

import edu.ifpb.dac.mdbshared.model.Produto;
import edu.ifpb.dac.mdbshared.service.ProdutoLojaDao;
import java.util.Optional;
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
@Local(ProdutoLojaDao.class)
public class ProdutoLojaDaoImpl implements ProdutoLojaDao {

    @PersistenceContext(unitName = "mdb")
    EntityManager entityManager;

    @Override
    public void cadastrarProduto(Produto produto) {
        entityManager.persist(produto);
    }

    @Override
    public boolean isRegisteredProduct(String descricao) {
       String querySql = "SELECT p FROM Produto p "
               + "WHERE p.descricao= :descricao";
        TypedQuery<Produto> query = entityManager
                .createQuery(querySql, Produto.class);
        query.setParameter("descricao", descricao);

        Optional<Produto> produto = query.getResultList().stream().findFirst();
        return produto.isPresent();
    }

//    @Override
//    public void removerProduto(Produto Produto) {
//        entityManager.remove(Produto);
//    }
}
