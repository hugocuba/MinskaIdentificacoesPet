/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp;

import br.edu.ifsp.control.Control;
import br.edu.ifsp.control.PedidoControl;
import br.edu.ifsp.control.PessoaControl;
import br.edu.ifsp.dao.PessoaDAO;
import br.edu.ifsp.dao.PessoaFisicaDAO;
import br.edu.ifsp.model.DetalhePedido;
import br.edu.ifsp.model.Pedido;
import br.edu.ifsp.model.Pessoa;
import br.edu.ifsp.model.PessoaFisica;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Hugo
 */
public class MinskaIdentificacoesPet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        /*Plaquinha p = new Plaquinha();
        p.setNome("Nome da plaquinha");
        p.setValor(BigDecimal.valueOf(10));
        p.setDescricao("Descricao da Plaquinha");
        p.setPeso(BigDecimal.valueOf(0.100));
        p.setQtdCampos(2);
        
        PlaquinhaDAO pDAO = new PlaquinhaDAO();
        
        Plaquinha p2 = pDAO.getById(2);
        
        System.out.println(p2.getDescricao());
        
        PessoaFisicaDAO pfDAO = new PessoaFisicaDAO();
        PessoaFisica p1 = pfDAO.getById(1);
        
        System.out.println(p1.getNome());*/
 /*Pessoa p = new Pessoa();
        
        p.setBairro("Gaivotas");
        p.setCep("11673460");
        p.setComplemento("");
        p.setDataCadastro("2016-06-28");
        p.setEmail("hscuba@gmail.com");
        p.setIdCidade(1);
        p.setLogradouro("Cardeal");
        p.setNome("Maria");
        p.setNumeroCasa(150);
        p.setIdPessoa(3);
        
        //PessoaDAO pDAO = new PessoaDAO();
        
        //pDAO.insert(p);
        
        PessoaFisica pf = new PessoaFisica();
        
        pf.setPessoa(p);
        
        pf.setDataNascimento("1988-03-31");
        
        PessoaFisicaDAO pfDAO = new PessoaFisicaDAO();*/
        Control<Pedido> control = new PedidoControl();

        for (Pedido pedido : control.listAll()) {

            System.out.println(pedido.getIdPedido() + ", " + pedido.getDataPedido().toString());

            for (DetalhePedido dp : pedido.getItens()) {

                System.out.println(
                        "--- " + dp.getPlaquinha().getNome()
                        + " = " + dp.getValor()
                );
            }

        }

    }

}
