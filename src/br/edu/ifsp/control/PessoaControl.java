/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.control;

import br.edu.ifsp.dao.DAO;
import br.edu.ifsp.dao.PessoaDAO;
import br.edu.ifsp.model.Pessoa;
import java.util.List;

/**
 * Classe de controle para Pessoa
 *
 * @author Hugo
 */
public class PessoaControl extends Control<Pessoa> {

    /**
     * Construtor da classe PessoaControl
     *
     * @param dao
     */
    public PessoaControl(DAO<Pessoa> dao) {
        super(new PessoaDAO());
    }

    /**
     * Método para o controle da listagem de todas as pessoas registradas no
     * sistema
     *
     * @return List
     */
    @Override
    public List<Pessoa> listAll() {
        return super.dao.listAll();
    }

    /**
     * Método para o controle da listagem das pessoas que são clientes
     *
     * @return List
     */
    public List<Pessoa> listCliente() {
        return dao.listCliente();
    }

    /**
     * Método para o controle da listagem das pessoas que são vendedores
     *
     * @return List
     */
    public List<Pessoa> listVendedor() {
        return super.dao.listVendedor();
    }
}
