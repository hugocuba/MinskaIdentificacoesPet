/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.control;

import br.edu.ifsp.dao.DAO;
import br.edu.ifsp.dao.PedidoDAO;
import br.edu.ifsp.model.Pedido;
import java.util.List;

/**
 *
 * @author Hugo
 */
public class PedidoControl extends Control<Pedido>{

    public PedidoControl(DAO<Pedido> dao) {
        super(new PedidoDAO());
    }

    @Override
    public List<Pedido> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}