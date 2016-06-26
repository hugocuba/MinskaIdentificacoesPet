/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.control;

import br.edu.ifsp.dao.DAO;
import br.edu.ifsp.dao.PlaquinhaDAO;
import br.edu.ifsp.model.Plaquinha;
import java.util.List;

/**
 *
 * @author Hugo
 */
public class PlaquinhaControl extends Control<Plaquinha>{

    public PlaquinhaControl(DAO<Plaquinha> dao) {
        super(new PlaquinhaDAO());
    }

    @Override
    public List<Plaquinha> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
