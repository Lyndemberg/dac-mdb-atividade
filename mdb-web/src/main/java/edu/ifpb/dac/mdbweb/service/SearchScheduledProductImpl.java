/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.mdbweb.service;

import edu.ifpb.dac.mdbshared.model.Produto;
import edu.ifpb.dac.mdbweb.util.GeneratorRandom;
import java.util.Optional;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author romulo
 */
@Singleton
public class SearchScheduledProductImpl {

    @PersistenceContext(unitName = "mdb")
    EntityManager entityManager;
    
    private String produtoDestaque;

    //Funciona
    private Produto searchProductScheduledById(int idProduct) {
        String querySql = "SELECT p FROM Produto p WHERE p.id= :id";
        TypedQuery<Produto> query = entityManager
                .createQuery(querySql, Produto.class);
        query.setParameter("id", idProduct);
        Optional<Produto> produto = query.getResultList().stream().findFirst();
        if (produto.isPresent()) {
            return produto.get();
        } else {
            return null;
        }
    }

    //Funciona
    private int returnUpperLimit() {
        String querySql = "SELECT max(p.id) FROM Produto p";
        TypedQuery<Integer> query = entityManager
                .createQuery(querySql, int.class);
        return query.getSingleResult();
    }
    
    @Schedule(hour = "*", minute = "*", second = "*/5")
    public void setProductFeatured() {
        //Debug Expresso
        System.out.println("Deus, Obrigado!!!!!!!!!!");
        
        int idUpperLimit = returnUpperLimit();
        int idRandom = GeneratorRandom.generateRandomIntInRange(idUpperLimit);
        while (!isExistentProduct(idRandom)) {
            idRandom = GeneratorRandom.generateRandomIntInRange(idUpperLimit);
        }
        //Debug Expresso
        System.out.println("Produto Destaque É: " 
                + searchProductScheduledById(idRandom).getDescricao());
        
        this.setProdutoDestaque(searchProductScheduledById(idRandom).getDescricao());
        
    }

    //Funciona
    private boolean isExistentProduct(int idProduct) {
        String querySql = "SELECT p FROM Produto p "
                + "WHERE p.id= :id";
        TypedQuery<Produto> query = entityManager
                .createQuery(querySql, Produto.class);
        query.setParameter("id", idProduct);
        Optional<Produto> produto = query.getResultList().stream().findFirst();
        return produto.isPresent();
    }

    public String getProdutoDestaque() {
        return produtoDestaque;
    }

    public void setProdutoDestaque(String produtoDestaque) {
        this.produtoDestaque = produtoDestaque;
    }

}
