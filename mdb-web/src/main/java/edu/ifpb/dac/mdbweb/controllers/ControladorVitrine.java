/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.mdbweb.controllers;

import edu.ifpb.dac.mdbweb.service.SearchScheduledProductImpl;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author romulo
 */
@Named
@RequestScoped
public class ControladorVitrine implements Serializable {

    @Inject
    private SearchScheduledProductImpl searchScheduledProduct;
    
    private String productFeatured;
    
    @PostConstruct
    public void init() {
        productFeatured = searchScheduledProduct.getProductFeatured();
    }
    
    public String getProductFeatured() {
        return productFeatured;
    }

    public void setProductFeatured(String productFeatured) {
        this.productFeatured = productFeatured;
    }

}
