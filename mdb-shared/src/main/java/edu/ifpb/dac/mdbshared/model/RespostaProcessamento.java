/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.mdbshared.model;

import java.io.Serializable;

/**
 *
 * @author romulo
 */
public class RespostaProcessamento implements Serializable {

    private String mensagem;
    private int codPedido;

    public RespostaProcessamento(String mensagem, int codPedido) {
        this.mensagem = mensagem;
        this.codPedido = codPedido;
    }

    public RespostaProcessamento(int codPedido) {
        this.codPedido = codPedido;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }

}
