package edu.ifpb.dac.mdbshared.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Ricardo Job
 */
@Entity
@SequenceGenerator(name = "PRO_SEQ", sequenceName = "PRODUTO_SEQ", 
        initialValue = 1, allocationSize = 1)
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRO_SEQ")
    private int id;
    private String descricao;
    private BigDecimal preco;

    public Produto() {
    }

    public Produto(String descricao, BigDecimal preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", descricao=" + descricao 
                + ", preco=" + preco + '}';
    }
    
}
