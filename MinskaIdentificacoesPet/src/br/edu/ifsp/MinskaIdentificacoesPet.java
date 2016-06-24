/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp;

import br.edu.ifsp.dao.PessoaFisicaDAO;
import br.edu.ifsp.dao.PlaquinhaDAO;
import br.edu.ifsp.model.DetalhePedido;
import br.edu.ifsp.model.Pedido;
import br.edu.ifsp.model.Pessoa;
import br.edu.ifsp.model.PessoaFisica;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Hugo
 */
public class MinskaIdentificacoesPet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    	// DAOs
    	PessoaFisicaDAO pfDao = new PessoaFisicaDAO();
    	PlaquinhaDAO placaDao = new PlaquinhaDAO();
    	
    	// Cliente
    	Pessoa cliente = pfDao.getById(2);
    	
    	// Vendedor
    	Pessoa vendedor = pfDao.getById(1);
    	
    	// Pedido
    	Pedido pedido = new Pedido();
    	pedido.setCliente(cliente);
    	pedido.setVendedor(vendedor);
    	pedido.setDataPedido(new Date("2016-06-01"));
    	
    	// Detalhe Pedido (itens pedido)
    	DetalhePedido item1 = new DetalhePedido();
    	item1.setItem(placaDao.getById(1));
    	item1.addTexto("Linha 1").addTexto("Linha 2");
    	DetalhePedido item2 = new DetalhePedido();
    	item2.setItem(placaDao.getById(2));
    	item2.addTexto("Linha 3").addTexto("Linha 4");
        
    }

}
