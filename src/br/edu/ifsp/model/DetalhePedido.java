/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.model;

import java.math.BigDecimal;

/**
 *
 * @author Hugo
 */
public class DetalhePedido implements IModel {

    private Pedido pedido;
    private Plaquinha plaquinha;
    private String textos;
    private BigDecimal valor;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Plaquinha getPlaquinha() {
        return plaquinha;
    }

    public void setPlaquinha(Plaquinha plaquinha) {
        this.plaquinha = plaquinha;
    }

    public String getTextos() {
        return textos;
    }

    public void setTextos(String textos) {
        this.textos = textos;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
}
