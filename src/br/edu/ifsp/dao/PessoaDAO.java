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
 * Classe DAO para as operações da classe Pessoa
 *
 * @author Hugo
 */
public class PessoaDAO extends DAO<Pessoa> {

    @Override
    public boolean insert(Pessoa objeto) {
        try {
            String sql = "insert into Pessoa(idCidade, nome, email, logradouro, numero, bairro, cep, complemento, dataCadastro) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

            sql = sql.replaceFirst("\\?", objeto.getIdCidade().toString());
            sql = sql.replaceFirst("\\?", "\"" + objeto.getNome() + "\"");
            sql = sql.replaceFirst("\\?", "\"" + objeto.getEmail() + "\"");
            sql = sql.replaceFirst("\\?", "\"" + objeto.getLogradouro()+ "\"");
            sql = sql.replaceFirst("\\?", objeto.getNumeroCasa().toString());
            sql = sql.replaceFirst("\\?", "\"" + objeto.getBairro() + "\"");
            sql = sql.replaceFirst("\\?", "\"" + objeto.getCep()+ "\"");
            sql = sql.replaceFirst("\\?", "\"" + objeto.getComplemento() + "\"");
            sql = sql.replaceFirst("\\?", "\"" + objeto.getDataCadastro()+ "\"");
            
            System.out.println(sql);

            System.out.println(database.insertAutoId(sql));

            /*
            Cadastrar dados físicos/jurídicos
             */
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            database.disconnect();
        }
    }

    @Override
    public boolean update(Pessoa objeto) {
        return false;
    }

    @Override
    public boolean delete(Pessoa objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método DAO para obter todas pessoas registradas no sistema
     *
     * @return List
     */
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

    /**
     * Metodo DAO para obter todas pessoas do sistema que são clientes
     *
     * @return List
     */
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

    /**
     * Método DAO para obter todas pessoas do sistema que são vendedores
     *
     * @return List
     */
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

    /**
     * Método DAO para obter uma pessoa através de seu ID
     *
     * @param id
     * @return Pessoa
     */
    @Override
    public Pessoa getById(int id) {
        Pessoa p = new Pessoa();

        String sql = "SELECT * from Pessoa where idPessoa = ?";
        sql = sql.replaceFirst("\\?", Integer.toString(id));

        try {
            database.connect();
            ResultSet rs = database.query(sql);
            if (rs.next()) {
                p.setIdPessoa(rs.getInt("idPessoa"));
                p.setIdCidade(rs.getInt("idCidade"));
                p.setNome(rs.getString("nome"));
                p.setEmail(rs.getString("email"));
                p.setLogradouro(rs.getString("logradouro"));
                p.setNumeroCasa(rs.getInt("numero"));
                p.setBairro(rs.getString("bairro"));
                p.setCep(rs.getString("cep"));
                p.setComplemento(rs.getString("complemento"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            database.disconnect();
        }
        return p;
    }

    /**
     * Método DAO para inserir uma nova pessoa no sistema
     *
     * @param objeto
     * @return int - O ID do cliente criado pelo banco de dados
     */
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
