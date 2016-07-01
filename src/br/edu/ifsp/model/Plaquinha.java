/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.model;

import java.math.BigDecimal;

/**
 * Classe da plaquinha
 *
 * @author Hugo
 */
public class Plaquinha implements IModel {

    private Integer idModeloPlaca;
    private BigDecimal valor;
    private String nome;
    private String descricao;
    private Integer qtdCampos;
    private BigDecimal peso;

    public Integer getIdModeloPlaca() {
        return idModeloPlaca;
    }

    public void setIdModeloPlaca(Integer idModeloPlaca) {
        this.idModeloPlaca = idModeloPlaca;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQtdCampos() {
        return qtdCampos;
    }

    public void setQtdCampos(Integer qtdCampos) {
        this.qtdCampos = qtdCampos;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

}
