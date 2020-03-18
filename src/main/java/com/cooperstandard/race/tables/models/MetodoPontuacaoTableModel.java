/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.race.tables.models;

import com.cooperstandard.race.models.MetodoPontuacao;
import com.cooperstandard.race.tables.interfaces.DefaultTableModelCustom;

/**
 * @author Tiago
 */
public class MetodoPontuacaoTableModel extends DefaultTableModelCustom<MetodoPontuacao> {

    @Override
    protected String[] getColumnsNames() {
        return new String[]{"Valor", "Comparação", "Pontuação"};
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MetodoPontuacao metodoPontuacao = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return metodoPontuacao.getValor();
            case 1:
                return metodoPontuacao.getComparacao();
            case 2:
                return metodoPontuacao.getPontuacao();
            default:
                return "";
        }
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        MetodoPontuacao metodoPontuacao = list.get(row);
        switch (column) {
            case 0:
                metodoPontuacao.setValor(Float.parseFloat(aValue.toString().replace(",", ".")));
                break;
            case 1:
                metodoPontuacao.setComparacao(aValue.toString());
                break;
            case 2:
                metodoPontuacao.setPontuacao(Long.parseLong(aValue.toString()));
                break;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Float.class;
            case 1:
                return String.class;
            case 2:
                return Long.class;
            default:
                return Object.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

}
