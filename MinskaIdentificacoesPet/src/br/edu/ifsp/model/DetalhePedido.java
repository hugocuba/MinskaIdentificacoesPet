/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.model;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Hugo
 */
public class DetalhePedido implements IModel{

    private int idDetalhePedido;
    private int idPedido;
    private int idModeloPlaca;
    private List<String> textos;
	private Plaquinha item;
    
    public List<String> getTextos() {
		return textos;
	}

	public void setTextos(List<String> textos) {
		this.textos = textos;
	}
	
	public DetalhePedido addTexto(String texto) {
		this.textos.add(texto);
		return this;
	}

    public Plaquinha getItem() {
		return item;
	}

	public void setItem(Plaquinha item) {
		this.item = item;
	}

	public int getIdDetalhePedido() {
        return idDetalhePedido;
    }

    public void setIdDetalhePedido(int idDetalhePedido) {
        this.idDetalhePedido = idDetalhePedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdModeloPlaca() {
        return this.item.getIdModeloPlaca();
    }

    public void setIdModeloPlaca(int idModeloPlaca) {
        this.idModeloPlaca = idModeloPlaca;
    }

}
