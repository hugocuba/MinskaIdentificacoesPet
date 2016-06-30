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

    private DetalhePedido detalhePedido;
    private String tipo;
    private String texto;

    public DetalhePedido getDetalhePedido() {
        return detalhePedido;
    }

    public void setDetalhePedido(DetalhePedido detalhePedido) {
        this.detalhePedido = detalhePedido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
