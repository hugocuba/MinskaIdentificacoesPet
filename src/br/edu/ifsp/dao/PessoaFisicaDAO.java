package br.edu.ifsp.dao;

import br.edu.ifsp.model.Pessoa;
import java.sql.ResultSet;
import java.util.List;

import br.edu.ifsp.model.PessoaFisica;
import java.util.ArrayList;

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
        try {

            database.connect();

            String sql = "update PessoaFisica set dataNascimento = ?, cpf = ?"
                    + "where idPessoa = ?";

            sql.replaceFirst("\\?", objeto.getDataNascimento().toString());
            sql.replaceFirst("\\?", objeto.getCpf().toString());
            sql.replaceFirst("\\?", objeto.getPessoa().getIdPessoa().toString());

            return database.update(sql);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            database.disconnect();
        }
    }

    @Override
    public boolean delete(PessoaFisica objeto) {
        try {
            database.connect();

            String sql = "delete from PessoaFisica where idPessoa = ?";

            sql.replaceFirst("\\?", objeto.getPessoa().getIdPessoa().toString());

            return database.delete(sql);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            database.disconnect();
        }
    }

    @Override
    public List<PessoaFisica> listAll() {
        
        List<PessoaFisica> list = new ArrayList<>();
        
        try{
            
            database.connect();
            
            String sql = "select idPessoa, dataNascimento, cpf from PessoaFisica";
            ResultSet rsPessoaFisica = database.query(sql);
            
            while(rsPessoaFisica.next()){
                PessoaFisica pf = new PessoaFisica();
                
                pf.setCpf(rsPessoaFisica.getString("cpf"));
                pf.setDataNascimento(rsPessoaFisica.getString("dataNascimento"));
                
                PessoaDAO pDAO = new PessoaDAO();
                Pessoa p = pDAO.getById(rsPessoaFisica.getInt("idPessoa"));
                
                pf.setPessoa(p);
                
                list.add(pf);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            database.disconnect();
        }
        
        return list;
        
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
