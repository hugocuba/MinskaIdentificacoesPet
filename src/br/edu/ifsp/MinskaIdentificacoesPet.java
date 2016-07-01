/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp;

import br.edu.ifsp.control.Control;
import br.edu.ifsp.control.PedidoControl;
import br.edu.ifsp.dao.PessoaDAO;
import br.edu.ifsp.model.DetalhePedido;
import br.edu.ifsp.model.Pedido;
import br.edu.ifsp.model.TextoPedido;
import br.edu.ifsp.view.PedidoForm;
import br.edu.ifsp.view.PlaquinhaForm;
import java.text.Normalizer.Form;

/**
 *
 * @author Hugo
 */
public class MinskaIdentificacoesPet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        /*Control<Pedido> control = new PedidoControl();

        for (Pedido pedido : control.listAll()) {
         
            System.out.println(pedido.getIdPedido() + ", " + pedido.getDataPedido().toString());
            
            for (DetalhePedido dp : pedido.getItens()) {

                System.out.println(
                        "--- " + dp.getPlaquinha().getNome()
                        + " = " + dp.getValor()
                );
                
                for(TextoPedido tp : dp.getTextos()){
                    
                    System.out.println(
                            "------ " + tp.getTipo() + ": " +tp.getTexto()
                    
                    );
                    
                }
                
            }

        }*/

        //PlaquinhaForm plaquinhaForm = new PlaquinhaForm();
        //plaquinhaForm.setVisible(true);
        
        PedidoForm pedidoForm = new PedidoForm();
        pedidoForm.setVisible(true);
    }

}
