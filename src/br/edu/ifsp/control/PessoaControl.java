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
 *
 * @author Hugo
 */
public class PessoaControl extends Control<Pessoa>{

    public PessoaControl(DAO<Pessoa> dao) {
        super(new PessoaDAO());
    }

    @Override
    public List<Pessoa> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
