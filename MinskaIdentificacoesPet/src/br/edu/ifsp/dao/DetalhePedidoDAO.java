/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.dao;

import br.edu.ifsp.model.DetalhePedido;
import br.edu.ifsp.model.PessoaFisica;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author hugo
 */
public class DetalhePedidoDAO extends DAO<DetalhePedido>{

    @Override
    public boolean insert(DetalhePedido objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(DetalhePedido objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(DetalhePedido objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetalhePedido> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	public DetalhePedido getById(int id) {
		return null;
		/*DetalhePedido p = new DetalhePedido();
		
		String sql = "SELECT p.*, pf.dataNascimento, pf.cpf FROM PessoaFisica AS pf, Pessoa AS p WHERE p.idPessoa=pf.idPessoa AND p.idPessoa=?";
		sql = sql.replaceFirst("\\?", Integer.toString(id));
		
		try {
			database.connect();
			ResultSet rs = database.query(sql);
			p.set
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		} finally {
			database.disconnect();
		}
		
		return p;*/
	}
    
}
