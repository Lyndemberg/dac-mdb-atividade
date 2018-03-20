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

    private String emailUser;
    private String mensagem;
    private int codPedido;

    public RespostaProcessamento(String mensagem, int codPedido, String emailUser) {
        this.mensagem = mensagem;
        this.codPedido = codPedido;
        this.emailUser = emailUser;
    }

    public RespostaProcessamento(int codPedido, String emailUser) {
        this.emailUser = emailUser;
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

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

}
