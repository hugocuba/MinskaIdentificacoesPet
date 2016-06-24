/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.dao;

import br.edu.ifsp.model.Pedido;
import java.util.List;

/**
 *
 * @author hugo
 */
public class PedidoDAO extends DAO<Pedido>{

    @Override
    public boolean insert(Pedido objeto) {
        try {

            database.connect();

            String sql = "INSERT INTO Pedido(idVendedor, idCliente) VALUES (?, ?)";
            sql = sql.replaceFirst("\\?", objeto.getIdVendedor().toString());
            sql = sql.replaceFirst("\\?", objeto.getIdCliente().toString());
            
            return database.insert(sql);

        } catch (Exception e) {
            
            e.printStackTrace();
            return false;
            
        } finally {

            database.disconnect();

        }
    }

    @Override
    public boolean update(Pedido objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Pedido objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pedido> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
