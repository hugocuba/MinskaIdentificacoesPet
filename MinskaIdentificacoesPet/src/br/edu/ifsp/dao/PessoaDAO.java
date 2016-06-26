/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.dao;

import br.edu.ifsp.model.Pessoa;
import java.util.List;

/**
 *
 * @author Hugo
 */
public class PessoaDAO extends DAO<Pessoa>{


    @Override
    public int insert(Pessoa objeto) {
        try {

            database.connect();

            String sql = "INSERT INTO Pessoa(idCidade, nome, email, logradouro, numero, bairro, cep, complemento, dataCadastro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            sql = sql.replaceFirst("\\?", objeto.getIdCidade().toString());
            sql = sql.replaceFirst("\\?", "\"" + objeto.getNome() + "\"");
            sql = sql.replaceFirst("\\?", "\"" + objeto.getEmail() + "\"");
            sql = sql.replaceFirst("\\?", "\"" + objeto.getLogradouro()+ "\"");
            sql = sql.replaceFirst("\\?", objeto.getNumeroCasa().toString());
            sql = sql.replaceFirst("\\?", "\"" + objeto.getBairro()+ "\"");
            sql = sql.replaceFirst("\\?", "\"" + objeto.getCep()+ "\"");
            sql = sql.replaceFirst("\\?", "\"" + objeto.getComplemento()+ "\"");
            sql = sql.replaceFirst("\\?", "\"" + objeto.getDataCadastro()+ "\"");
            
            return database.insert(sql);

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        } finally {

            database.disconnect();

        }
    }

    @Override
    public boolean update(Pessoa objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Pessoa objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pessoa> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pessoa getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
