/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.control;

import br.edu.ifsp.dao.DAO;
import br.edu.ifsp.dao.PessoaJuridicaDAO;
import br.edu.ifsp.model.PessoaJuridica;
import java.util.List;

/**
 *
 * @author Hugo
 */
public class PessoaJuridicaControl extends Control<PessoaJuridica> {

    /**
     * Método construtor do controller de PessoaJuridica
     *
     * @param dao
     */
    public PessoaJuridicaControl(DAO<PessoaJuridica> dao) {
        super(new PessoaJuridicaDAO());
    }

    /**
     * Método controller para a listagem de todas pessoas jurídicas do sistema
     *
     * @return List
     */
    @Override
    public List<PessoaJuridica> listAll() {
        return super.dao.listAll();
    }

}
