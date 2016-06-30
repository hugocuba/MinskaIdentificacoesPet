/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.view.model;

import br.edu.ifsp.model.Plaquinha;
import java.math.BigDecimal;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hugo
 */
public class PlaquinhaTableModel extends DefaultTableModel {

    private static final long serialVersionUID = 3472716354338896651L;

    public PlaquinhaTableModel(String[] header, Object[][] rows) {

        for (String c : header) {
            super.addColumn(c);
        }

        for (Object[] o : rows) {
            super.addRow(o);
        }
    }

    public void clearRows() {

        while (super.getColumnCount() > 0) {
            super.removeRow(0);
        }
    }

    public Class<?>[] types = new Class[]{
        String.class, String.class, BigDecimal.class, Integer.class, BigDecimal.class
    };

    boolean[] canEdit = new boolean[]{false, false, false, false, false};


    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return types[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
    }

    public void addRow(String nome, String descricao, BigDecimal peso, Integer qtdCampos, BigDecimal valor) {
        super.addRow(new Object[]{nome, descricao, peso, qtdCampos, valor});
    }

    public void addRow(Plaquinha plaquinha) {
        super.addRow(new Object[]{plaquinha.getNome(), plaquinha.getDescricao(), plaquinha.getPeso(), plaquinha.getQtdCampos(), plaquinha.getValor()});
    }
}
