/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.control;

import br.edu.ifsp.dao.DAO;
import br.edu.ifsp.dao.PlaquinhaDAO;
import br.edu.ifsp.model.Plaquinha;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Hugo
 */
public class PlaquinhaControl extends Control<Plaquinha> {

    public PlaquinhaControl(DAO<Plaquinha> dao) {
        super(new PlaquinhaDAO());
    }

    @Override
    public List<Plaquinha> listAll() {
        return super.dao.listAll();
    }

    public boolean insert(Map<String, JTextComponent> dadosFormPlaquinha) {

        Plaquinha p = new Plaquinha();

        try {

            p.setNome(dadosFormPlaquinha.get("nome").getText());
            p.setDescricao(dadosFormPlaquinha.get("descricao").getText());
            p.setQtdCampos(Integer.parseInt(dadosFormPlaquinha.get("qtdCampos").getText()));
            p.setValor(new BigDecimal(dadosFormPlaquinha.get("valor").getText()));
            p.setPeso(new BigDecimal(dadosFormPlaquinha.get("peso").getText()));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dao.insert(p);
    }
    
    public boolean update(Map<String, JTextComponent> dadosFormPlaquinha){
        
        Plaquinha p = new Plaquinha();
        
        try{
            
            p.setNome(dadosFormPlaquinha.get("nome").getText());
            p.setDescricao(dadosFormPlaquinha.get("descricao").getText());
            p.setQtdCampos(Integer.parseInt(dadosFormPlaquinha.get("qtdCampos").getText()));
            p.setValor(new BigDecimal(dadosFormPlaquinha.get("valor").getText()));
            p.setPeso(new BigDecimal(dadosFormPlaquinha.get("peso").getText()));
            p.setIdModeloPlaca(Integer.parseInt(dadosFormPlaquinha.get("id").getText()));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return dao.update(p);
    }
    
    public boolean delete(Map<String, JTextComponent> dadosFormPlaquinha){
        
        Plaquinha p = new Plaquinha();
        
        try{
            p.setIdModeloPlaca(Integer.parseInt(dadosFormPlaquinha.get("id").getText()));
            return dao.delete(p);
            
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
