package br.edu.ifsp.dao;

import java.sql.ResultSet;
import java.util.List;

import br.edu.ifsp.model.PessoaFisica;

public class PessoaFisicaDAO extends DAO<PessoaFisica> {

    @Override
    public boolean insert(PessoaFisica objeto) {
        try {

            database.connect();

            String sql = "INSERT INTO PessoaFisica(idPessoa, dataNascimento, cpf) VALUES (?, ?, ?)";
            sql = sql.replaceFirst("\\?", objeto.getPessoa().getIdPessoa().toString());
            sql = sql.replaceFirst("\\?", "\"" + objeto.getDataNascimento() + "\"");
            sql = sql.replaceFirst("\\?", "\"" + objeto.getCpf() + "\"");

            return database.insert(sql);

        } catch (Exception e) {

            e.getMessage();
            return false;

        } finally {

            database.disconnect();

        }
    }

    @Override
    public boolean update(PessoaFisica objeto) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(PessoaFisica objeto) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<PessoaFisica> listAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PessoaFisica getById(int id) {
        PessoaFisica p = new PessoaFisica();

        String sql = "SELECT p.*, pf.dataNascimento, pf.cpf FROM PessoaFisica AS pf, Pessoa AS p WHERE p.idPessoa=pf.idPessoa AND p.idPessoa=?";
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
                p.setDataNascimento(rs.getString("dataNascimento"));
                p.setCpf(rs.getString("cpf"));
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
    public int insertAutoId(PessoaFisica objeto) {
        return 0;
    }

}
