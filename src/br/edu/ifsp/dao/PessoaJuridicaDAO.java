/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.dao;

import br.edu.ifsp.model.Pessoa;
import br.edu.ifsp.model.PessoaJuridica;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe DAO para operações referentes à Pessoa Juridica
 *
 * @author Hugo
 */
public class PessoaJuridicaDAO extends DAO<PessoaJuridica> {

    /**
     * Método DAO para inserir a parte jurídica de uma pessoa
     *
     * @param objeto
     * @return boolean - True em caso de sucesso
     */
    @Override
    public boolean insert(PessoaJuridica objeto) {
        try {

            database.connect();

            String sql = "INSERT INTO PessoaJuridica(idPessoa, cnpj, razaoSocial, inscrocaoEstadual) VALUES (?, ?, ?, ?)";
            sql = sql.replaceFirst("\\?", objeto.getPessoa().getIdPessoa().toString());
            sql = sql.replaceFirst("\\?", "\"" + objeto.getCnpj() + "\"");
            sql = sql.replaceFirst("\\?", "\"" + objeto.getRazaoSocial() + "\"");
            sql = sql.replaceFirst("\\?", "\"" + objeto.getInscricaoEstadual() + "\"");

            return database.insert(sql);

        } catch (Exception e) {

            e.getMessage();
            return false;

        } finally {

            database.disconnect();

        }
    }

    /**
     * Método para atualizar os dados refentes à uma pessoa juridíca
     *
     * @param objeto
     * @return boolean - True em caso de sucesso
     */
    @Override
    public boolean update(PessoaJuridica objeto) {
        try {

            database.connect();

            String sql = "update PessoaJuridica set cnpj = ?, razaoSocial = ?, inscricaoEstadual = ?"
                    + "where idPessoa = ?";

            sql = sql.replaceFirst("\\?", objeto.getCnpj());
            sql = sql.replaceFirst("\\?", objeto.getRazaoSocial());
            sql = sql.replaceFirst("\\?", objeto.getInscricaoEstadual());
            sql = sql.replaceFirst("\\?", objeto.getPessoa().getIdPessoa().toString());

            return database.update(sql);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            database.disconnect();
        }
    }

    /**
     * Método para excluir permanentemente os dados referentes à pessoa juridica
     *
     * @param objeto
     * @return boolean - True em caso de sucesso
     */
    @Override
    public boolean delete(PessoaJuridica objeto) {
        try {
            database.connect();

            String sql = "delete from PessoaFisica where idPessoa = ?";

            sql = sql.replaceFirst("\\?", objeto.getPessoa().getIdPessoa().toString());

            return database.delete(sql);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            database.disconnect();
        }
    }

    /**
     * Método DAO para obter as informações da parte jurídica de todas pessoas
     * desse tipo no sistema
     *
     * @return List
     */
    @Override
    public List<PessoaJuridica> listAll() {

        List<PessoaJuridica> list = new ArrayList<>();

        try {

            database.connect();
            String sql = "select idPessoa, cnpj, razaoSocial, inscricaoEstadual from PessoaJuridica";

            ResultSet rsPessoaJuridica = database.query(sql);

            while (rsPessoaJuridica.next()) {

                PessoaJuridica pj = new PessoaJuridica();

                pj.setCnpj(rsPessoaJuridica.getString("cnpj"));
                pj.setInscricaoEstadual(rsPessoaJuridica.getString("inscricaoEstadual"));
                pj.setRazaoSocial(rsPessoaJuridica.getString("razaoSocial"));

                PessoaDAO pDAO = new PessoaDAO();
                Pessoa p = pDAO.getById(rsPessoaJuridica.getInt(("idPessoa")));

                pj.setPessoa(p);

                list.add(pj);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            database.disconnect();
        }

        return list;
    }

    /**
     * Método DAO para obter todos os dados de uma pessoa jurídica através de
     * seu ID
     *
     * @param id
     * @return PessoaJuridica
     */
    @Override
    public PessoaJuridica getById(int id) {
        PessoaJuridica p = new PessoaJuridica();

        String sql = "SELECT p.*, pj.razaoSocial, pj.cnpj, pj.inscricaoEstadual FROM PessoaJuridica AS pj, Pessoa AS p WHERE p.idPessoa=pj.idPessoa AND p.idPessoa=?";
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
                p.setCnpj(rs.getString("dataNascimento"));
                p.setInscricaoEstadual(rs.getString("cpf"));
                p.setRazaoSocial(rs.getString("inscricaoSocial"));
                p.setCnpj(rs.getString("cnpj"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            database.disconnect();
        }

        return p;
    }

    @Override
    public int insertAutoId(PessoaJuridica objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
