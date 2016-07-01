/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.control;

import br.edu.ifsp.dao.DAO;
import br.edu.ifsp.dao.PessoaFisicaDAO;
import br.edu.ifsp.model.PessoaFisica;
import java.util.List;

/**
 *
 * @author Hugo
 */
public class PessoaFisicaControl extends Control<PessoaFisica> {

    /**
     * Método construtor do controller de PessoaFisica
     *
     * @param dao
     */
    public PessoaFisicaControl(DAO<PessoaFisica> dao) {
        super(new PessoaFisicaDAO());
    }

    /**
     * Método controller para a listagem de todos as pessoas físicas do sistema
     *
     * @return List
     */
    @Override
    public List<PessoaFisica> listAll() {
        return super.dao.listAll();
    }

}
