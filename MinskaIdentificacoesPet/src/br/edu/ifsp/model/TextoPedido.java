/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.model;

/**
 *
 * @author hugo
 */
public class TextoPedido implements IModel {

    private int idDetalhePedido;
    private char tipo;
    private String texto;

    public int getIdDetalhePedido() {
        return idDetalhePedido;
    }

    public void setIdDetalhePedido(int idDetalhePedido) {
        this.idDetalhePedido = idDetalhePedido;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
