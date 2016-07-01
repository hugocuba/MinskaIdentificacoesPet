/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.dao;

import br.edu.ifsp.model.Pessoa;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hugo
 */
public class PessoaDAO extends DAO<Pessoa> {

    @Override
    public boolean insert(Pessoa objeto) {
        return false;
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
        List<Pessoa> list = new ArrayList<>();

        try {

            database.connect();

            String sql = "select * from Pessoa";

            ResultSet rsPessoas = database.query(sql);

            while (rsPessoas.next()) {
                Pessoa p = new Pessoa();

                p.setBairro(rsPessoas.getString("bairro"));
                p.setCep(rsPessoas.getString("cep"));
                p.setComplemento(rsPessoas.getString("complemento"));
                p.setDataCadastro(rsPessoas.getString("dataCadastro"));
                p.setEmail(rsPessoas.getString("email"));
                p.setIdCidade(rsPessoas.getInt("idCidade"));
                p.setIdPessoa(rsPessoas.getInt("idPessoa"));
                p.setLogradouro(rsPessoas.getString("logradouro"));
                p.setNome(rsPessoas.getString("nome"));
                p.setNumeroCasa(rsPessoas.getInt("numero"));

                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            database.disconnect();
        }
        return list;
    }

    public List<Pessoa> listCliente() {
        List<Pessoa> list = new ArrayList<>();

        try {

            database.connect();

            String sql = "select * from Pessoa natural join cliente";

            ResultSet rsPessoas = database.query(sql);

            while (rsPessoas.next()) {
                Pessoa p = new Pessoa();

                p.setBairro(rsPessoas.getString("bairro"));
                p.setCep(rsPessoas.getString("cep"));
                p.setComplemento(rsPessoas.getString("complemento"));
                p.setDataCadastro(rsPessoas.getString("dataCadastro"));
                p.setEmail(rsPessoas.getString("email"));
                p.setIdCidade(rsPessoas.getInt("idCidade"));
                p.setIdPessoa(rsPessoas.getInt("idPessoa"));
                p.setLogradouro(rsPessoas.getString("logradouro"));
                p.setNome(rsPessoas.getString("nome"));
                p.setNumeroCasa(rsPessoas.getInt("numero"));

                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            database.disconnect();
        }
        return list;
    }

    public List<Pessoa> listVendedor() {
        List<Pessoa> list = new ArrayList<>();

        try {

            database.connect();

            String sql = "select * from Pessoa natural join vendedor";

            ResultSet rsPessoas = database.query(sql);

            while (rsPessoas.next()) {
                Pessoa p = new Pessoa();

                p.setBairro(rsPessoas.getString("bairro"));
                p.setCep(rsPessoas.getString("cep"));
                p.setComplemento(rsPessoas.getString("complemento"));
                p.setDataCadastro(rsPessoas.getString("dataCadastro"));
                p.setEmail(rsPessoas.getString("email"));
                p.setIdCidade(rsPessoas.getInt("idCidade"));
                p.setIdPessoa(rsPessoas.getInt("idPessoa"));
                p.setLogradouro(rsPessoas.getString("logradouro"));
                p.setNome(rsPessoas.getString("nome"));
                p.setNumeroCasa(rsPessoas.getInt("numero"));

                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            database.disconnect();
        }
        return list;
    }

    @Override
    public Pessoa getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertAutoId(Pessoa objeto) {
        try {

            database.connect();

            String sql = "INSERT INTO Pessoa(idCidade, nome, email, logradouro, numero, bairro, cep, complemento, dataCadastro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            sql = sql.replaceFirst("\\?", objeto.getIdCidade().toString());
            sql = sql.replaceFirst("\\?", "\"" + objeto.getNome() + "\"");
            sql = sql.replaceFirst("\\?", "\"" + objeto.getEmail() + "\"");
            sql = sql.replaceFirst("\\?", "\"" + objeto.getLogradouro() + "\"");
            sql = sql.replaceFirst("\\?", objeto.getNumeroCasa().toString());
            sql = sql.replaceFirst("\\?", "\"" + objeto.getBairro() + "\"");
            sql = sql.replaceFirst("\\?", "\"" + objeto.getCep() + "\"");
            sql = sql.replaceFirst("\\?", "\"" + objeto.getComplemento() + "\"");
            sql = sql.replaceFirst("\\?", "\"" + objeto.getDataCadastro() + "\"");

            return database.insertAutoId(sql);

        } catch (Exception e) {

            e.getMessage();
            return 0;

        } finally {

            database.disconnect();

        }
    }
}
