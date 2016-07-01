/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp;

import br.edu.ifsp.control.Control;
import br.edu.ifsp.control.PedidoControl;
import br.edu.ifsp.control.PessoaFisicaControl;
import br.edu.ifsp.control.PessoaJuridicaControl;
import br.edu.ifsp.dao.PedidoDAO;
import br.edu.ifsp.dao.PessoaDAO;
import br.edu.ifsp.dao.PessoaFisicaDAO;
import br.edu.ifsp.dao.PessoaJuridicaDAO;
import br.edu.ifsp.dao.PlaquinhaDAO;
import br.edu.ifsp.model.DetalhePedido;
import br.edu.ifsp.model.Pedido;
import br.edu.ifsp.model.Pessoa;
import br.edu.ifsp.model.PessoaFisica;
import br.edu.ifsp.model.PessoaJuridica;
import br.edu.ifsp.model.Plaquinha;
import br.edu.ifsp.model.TextoPedido;
import br.edu.ifsp.view.PedidoForm;
import br.edu.ifsp.view.PlaquinhaForm;
import java.text.DateFormat;
import java.text.Normalizer.Form;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Hugo
 */
public class MinskaIdentificacoesPet {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

/*        System.out.println("PEDIDOS\n");

        Control<Pedido> control = new PedidoControl();

        for (Pedido pedido : control.listAll()) {

            System.out.println(pedido.getIdPedido() + ", " + pedido.getDataPedido().toString());

            for (DetalhePedido dp : pedido.getItens()) {

                System.out.println(
                        "--- " + dp.getPlaquinha().getNome()
                        + " = " + dp.getValor()
                );

                for (TextoPedido tp : dp.getTextos()) {

                    System.out.println(
                            "------ " + tp.getTipo() + ": " + tp.getTexto()
                    );

                }

            }

        }

        System.out.println("\nPESSOAS FISICAS\n");
        Control<PessoaFisica> controlpf = new PessoaFisicaControl(new PessoaFisicaDAO());

        for (PessoaFisica pf : controlpf.listAll()) {
            System.out.println(pf.getPessoa().getNome());
            System.out.println(pf.getCpf());
        }

        System.out.println("\nPESSOAS JURIDICAS\n");
        Control<PessoaJuridica> controlpj = new PessoaJuridicaControl(new PessoaJuridicaDAO());

        for (PessoaJuridica pj : controlpj.listAll()) {
            System.out.println(pj.getPessoa().getNome());
            System.out.println(pj.getCnpj());
        }

        System.out.println("\n/// REALIZANDO UMA COMPRA ///\n");

        PessoaDAO pDAO = new PessoaDAO();
        PlaquinhaDAO plaquinhaDAO = new PlaquinhaDAO();

        Pessoa cliente = pDAO.getById(1);
        Pessoa vendedor = pDAO.getById(2);

        Pedido pedido = new Pedido();

        pedido.setCliente(cliente);
        pedido.setVendedor(vendedor);
        pedido.setDataPedido("2016-07-01");

        Plaquinha plaquinha = plaquinhaDAO.getById(1);

        List<DetalhePedido> listDp = new ArrayList<>();

        DetalhePedido dp = new DetalhePedido();
        dp.setPedido(pedido);
        dp.setPlaquinha(plaquinha);
        dp.setValor(plaquinha.getValor());

        listDp.add(dp);

        List<TextoPedido> listTexto = new ArrayList<>();

        TextoPedido tp1 = new TextoPedido();
        tp1.setDetalhePedido(dp);
        tp1.setTipo("D");
        tp1.setTexto("Mateus");

        TextoPedido tp2 = new TextoPedido();
        tp2.setDetalhePedido(dp);
        tp2.setTipo("T");
        tp2.setTexto("(12) 98163-6528");

        TextoPedido tp3 = new TextoPedido();
        tp3.setDetalhePedido(dp);
        tp3.setTipo("N");
        tp3.setTexto("Totó");

        listTexto.add(tp1);
        listTexto.add(tp2);
        listTexto.add(tp3);

        dp.setTextos(listTexto);

        pedido.setItens(listDp);

        PedidoDAO pedidoDao = new PedidoDAO();
        int codPedido = pedidoDao.insertAutoId(pedido);
*/
        Pessoa p = new Pessoa();
        p.setBairro("Bairro");
        p.setCep("11673460");
        p.setComplemento("Complemento");
        p.setDataCadastro("2016-07-01");
        p.setEmail("email@servidor.com");
        p.setIdCidade(1);
        p.setLogradouro("Nome da rua");
        p.setNome("Pessoa da silva");
        p.setNumeroCasa(150);
        
        PessoaJuridica pj = new PessoaJuridica();
        pj.setCnpj("00000000000000");
        pj.setInscricaoEstadual("000000000");
        pj.setRazaoSocial("Razao Social");
        pj.setPessoa(p);
        
        p.setTipo(pj);
        
        PessoaDAO pDAO = new PessoaDAO();
        pDAO.insertAutoId(p);
    }

}
