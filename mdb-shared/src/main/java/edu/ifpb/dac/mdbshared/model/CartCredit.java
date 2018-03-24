/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.mdbshared.model;

import java.math.BigDecimal;

/**
 *
 * @author romulo
 */
public class CartCredit {

    private BigDecimal saldo;

    public CartCredit() {
        this.saldo = new BigDecimal(500);
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public boolean fazerPagamento(BigDecimal valorCompra) {
        if (this.getSaldo().compareTo(valorCompra) != -1) {
            BigDecimal saldoAtual = this.getSaldo();
            this.setSaldo(saldoAtual.subtract(valorCompra));
            return true;
        }
        return false;
    }

}
