/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.dao;

import br.edu.ifsp.model.DetalhePedido;
import br.edu.ifsp.model.Pedido;
import br.edu.ifsp.model.Pessoa;
import br.edu.ifsp.model.Plaquinha;
import br.edu.ifsp.model.TextoPedido;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hugo
 */
public class PedidoDAO extends DAO<Pedido> {

    @Override
    public boolean insert(Pedido objeto) {
        throw new UnsupportedOperationException("Por favor, utiliza o método insertAutoId."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Pedido objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Pedido objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pedido> listAll() {

        List<Pedido> list = new ArrayList<>();

        try {

            database.connect();

            String sqlPedido = "SELECT idPedido, idVendedor, idCliente, dataPedido, finalizado FROM Pedido";

            ResultSet rsPedido = database.query(sqlPedido);

            while (rsPedido.next()) {

                Pedido pedido = new Pedido();

                pedido.setIdPedido(rsPedido.getInt("idPedido"));
                pedido.setDataPedido(rsPedido.getString("dataPedido"));
                pedido.setFinalizado(rsPedido.getBoolean("finalizado"));

                String sqlCliente = "select * from Pessoa "
                        + "natural join Cliente "
                        + "where idPessoa = " + rsPedido.getInt("idCliente");

                ResultSet rsCliente = database.query(sqlCliente);

                String sqlVendedor = "select * from Pessoa "
                        + "natural join Vendedor "
                        + "where idPessoa = " + rsPedido.getInt("idVendedor");

                ResultSet rsVendedor = database.query(sqlVendedor);

                Pessoa cliente = new Pessoa();
                if (rsCliente.next()) {

                    cliente.setBairro(rsCliente.getString("bairro"));
                    cliente.setCep(rsCliente.getString("cep"));
                    cliente.setComplemento(rsCliente.getString("complemento"));
                    cliente.setDataCadastro(rsCliente.getString("dataCadastro"));
                    cliente.setEmail(rsCliente.getString("email"));
                    cliente.setIdCidade(rsCliente.getInt("idCidade"));
                    cliente.setIdPessoa(rsCliente.getInt("idPessoa"));
                    cliente.setLogradouro(rsCliente.getString("logradouro"));
                    cliente.setNome(rsCliente.getString("nome"));
                    cliente.setNumeroCasa(rsCliente.getInt("numero"));
                }

                Pessoa vendedor = new Pessoa();
                if (rsVendedor.next()) {

                    vendedor.setBairro(rsVendedor.getString("bairro"));
                    vendedor.setCep(rsVendedor.getString("cep"));
                    vendedor.setComplemento(rsVendedor.getString("complemento"));
                    vendedor.setDataCadastro(rsVendedor.getString("dataCadastro"));
                    vendedor.setEmail(rsVendedor.getString("email"));
                    vendedor.setIdCidade(rsVendedor.getInt("idCidade"));
                    vendedor.setIdPessoa(rsVendedor.getInt("idPessoa"));
                    vendedor.setLogradouro(rsVendedor.getString("logradouro"));
                    vendedor.setNome(rsVendedor.getString("nome"));
                    vendedor.setNumeroCasa(rsVendedor.getInt("numero"));
                }

                pedido.setCliente(cliente);
                pedido.setVendedor(vendedor);

                String sqlDetalhePedido = "SELECT idDetalhePedido, idPedido, idModeloPlaca, valor "
                        + "FROM DetalhePedido "
                        + "WHERE idPedido = " + rsPedido.getInt("idPedido");

                ResultSet rsDetalhePedido = database.query(sqlDetalhePedido);

                List<DetalhePedido> itensPedidos = new ArrayList<>();

                while (rsDetalhePedido.next()) {

                    DetalhePedido dp = new DetalhePedido();

                    dp.setIdDetalhePedido(rsDetalhePedido.getInt("idDetalhePedido"));
                    dp.setPedido(pedido);
                    dp.setValor(rsDetalhePedido.getBigDecimal("valor"));

                    String sqlPlaquinha
                            = "SELECT idModeloPlaca, valor, nome, descricao, qtdCampos, peso "
                            + "FROM ModeloPlaca "
                            + "WHERE idModeloPlaca = " + rsDetalhePedido.getInt("idModeloPlaca");

                    ResultSet rsPlaquinha = database.query(sqlPlaquinha);

                    if (rsPlaquinha.next()) {

                        Plaquinha plaquinha = new Plaquinha();

                        plaquinha.setDescricao(rsPlaquinha.getString("descricao"));
                        plaquinha.setIdModeloPlaca(rsPlaquinha.getInt("idModeloPlaca"));
                        plaquinha.setNome(rsPlaquinha.getString("nome"));
                        plaquinha.setPeso(rsPlaquinha.getBigDecimal("valor"));
                        plaquinha.setQtdCampos(rsPlaquinha.getInt("qtdCampos"));
                        plaquinha.setValor(rsPlaquinha.getBigDecimal("valor"));

                        dp.setPlaquinha(plaquinha);
                    }

                    itensPedidos.add(dp);

                    String sqlTextoPedido
                            = "select * from TextoPedido "
                            + "where idDetalhePedido = " + dp.getIdDetalhePedido();

                    ResultSet rsTextoPedido = database.query(sqlTextoPedido);

                    List<TextoPedido> textos = new ArrayList<>();

                    while (rsTextoPedido.next()) {

                        TextoPedido tp = new TextoPedido();

                        tp.setTexto(rsTextoPedido.getString("texto"));
                        tp.setTipo(rsTextoPedido.getString("tipo"));
                        tp.setDetalhePedido(dp);

                        textos.add(tp);

                    }

                    dp.setTextos(textos);

                }

                pedido.setItens(itensPedidos);

                list.add(pedido);
            }

        } catch (SQLException e) {

            e.getMessage();
            list.clear();

        } finally {

            database.disconnect();

        }

        return list;

    }

    @Override
    public int insertAutoId(Pedido objeto) {
        try {
            database.connect();

            String sql = "insert into Pedido(idVendedor, idCliente, dataPedido) values (?, ?, ?)";
            
            sql = sql.replaceFirst("\\?", objeto.getCliente().getIdPessoa().toString());
            sql = sql.replaceFirst("\\?", objeto.getVendedor().getIdPessoa().toString());
            sql = sql.replaceFirst("\\?", "\"" + objeto.getDataPedido().toString() + "\"");
            
            Integer codPedido = database.insertAutoId(sql);
            
            System.out.println(codPedido);
            
            for(DetalhePedido dp : objeto.getItens()){
                
                System.out.println(dp.getValor());
                
                String sqlDetalhe = "insert into DetalhePedido(idPedido, idModeloPlaca, valor )values(?, ?, ?)";
                
                sqlDetalhe = sqlDetalhe.replaceFirst("\\?", codPedido.toString());
                sqlDetalhe = sqlDetalhe.replaceFirst("\\?", dp.getPlaquinha().getIdModeloPlaca().toString());
                sqlDetalhe = sqlDetalhe.replaceFirst("\\?", dp.getValor().toString());
                
                Integer codDetalhe = database.insertAutoId(sqlDetalhe);
                
                for(TextoPedido tp : dp.getTextos()){
                    String sqlTexto = "insert into TextoPedido values (?,?,?)";
                    
                    sqlTexto = sqlTexto.replaceFirst("\\?", codDetalhe.toString());
                    sqlTexto = sqlTexto.replaceFirst("\\?", "\"" + tp.getTipo().toString() + "\"");
                    sqlTexto = sqlTexto.replaceFirst("\\?", "\"" + tp.getTexto().toString() + "\"");
                    
                    System.out.println(sqlTexto);
                    
                    database.insert(sqlTexto);
                }
                
            }
            
            return 1;
            
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            database.disconnect();
        }
    }

    @Override
    public Pedido getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
