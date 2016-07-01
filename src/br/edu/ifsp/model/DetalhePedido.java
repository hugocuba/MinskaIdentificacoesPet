/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * Classe para os ítens (plaquinhas) do pedido
 *
 * @author Hugo
 */
public class DetalhePedido implements IModel {

    private Integer idDetalhePedido;
    private Pedido pedido;
    private Plaquinha plaquinha;
    private List<TextoPedido> textos;
    private BigDecimal valor;

    public Integer getIdDetalhePedido() {
        return idDetalhePedido;
    }

    public void setIdDetalhePedido(Integer idDetalhePedido) {
        this.idDetalhePedido = idDetalhePedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public List<TextoPedido> getTextos() {
        return textos;
    }

    public void setTextos(List<TextoPedido> textos) {
        this.textos = textos;
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

}
