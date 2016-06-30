/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.dao;

import br.edu.ifsp.model.Plaquinha;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hugo
 */
public class PlaquinhaDAO extends DAO<Plaquinha> {

    @Override
    public boolean insert(Plaquinha objeto) {
        try {

            database.connect();

            String sql = "INSERT INTO ModeloPlaca(valor, nome, descricao, qtdCampos, peso) VALUES (?, ?, ?, ?, ?)";
            sql = sql.replaceFirst("\\?", objeto.getValor().toString());
            sql = sql.replaceFirst("\\?", "\"" + objeto.getNome() + "\"");
            sql = sql.replaceFirst("\\?", "\"" + objeto.getDescricao() + "\"");
            sql = sql.replaceFirst("\\?", objeto.getQtdCampos().toString());
            sql = sql.replaceFirst("\\?", objeto.getPeso().toString());

            return database.insert(sql);

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        } finally {

            database.disconnect();

        }
    }

    @Override
    public boolean update(Plaquinha objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Plaquinha objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Plaquinha> listAll() {
        List<Plaquinha> list = new ArrayList<>();

        try {

            database.connect();

            String sql = "select * from ModeloPlaca";

            ResultSet rsPlaquinhas = database.query(sql);

            while (rsPlaquinhas.next()) {
                Plaquinha p = new Plaquinha();

                p.setDescricao(rsPlaquinhas.getString("descricao"));
                p.setIdModeloPlaca(rsPlaquinhas.getInt("idModeloPlaca"));
                p.setNome(rsPlaquinhas.getString("nome"));
                p.setPeso(rsPlaquinhas.getBigDecimal("peso"));
                p.setQtdCampos(rsPlaquinhas.getInt("qtdCampos"));
                p.setValor(rsPlaquinhas.getBigDecimal("valor"));

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
    public Plaquinha getById(int id) {
        Plaquinha p = new Plaquinha();

        String sql = "SELECT * FROM ModeloPlaca WHERE idModeloPlaca = ?";
        sql = sql.replaceFirst("\\?", Integer.toString(id));

        try {
            database.connect();
            ResultSet rs = database.query(sql);
            if (rs.next()) {
                p.setIdModeloPlaca(rs.getInt("idModeloPlaca"));
                p.setValor(rs.getBigDecimal("valor"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setQtdCampos(rs.getInt("qtdCampos"));
                p.setPeso(rs.getBigDecimal("peso"));
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
    public int insertAutoId(Plaquinha objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
