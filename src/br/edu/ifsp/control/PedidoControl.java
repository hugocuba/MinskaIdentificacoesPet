/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.control;

import br.edu.ifsp.dao.PedidoDAO;
import br.edu.ifsp.model.Pedido;
import java.util.List;

/**
 * Classe de controle para os objetos do tipo Pedido.
 *
 * @author Hugo
 */
public class PedidoControl extends Control<Pedido> {

    /**
     * Construtor da classe PedidoControl
     */
    public PedidoControl() {
        super(new PedidoDAO());
    }

    /**
     * Método de controle para a listagem de todos os pedidos já realizados
     *
     * @return List
     */
    @Override
    public List<Pedido> listAll() {
        return super.dao.listAll();
    }

}
