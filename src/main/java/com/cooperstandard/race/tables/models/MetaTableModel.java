/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.race.tables.models;

import com.cooperstandard.race.models.MetodoPontuacao;
import com.cooperstandard.race.tables.interfaces.DefaultTableModelCustom;

import javax.swing.*;
import java.awt.*;

/**
 * @author Tiago
 */
public class MetaTableModel extends DefaultTableModelCustom<MetodoPontuacao> {

    @Override
    protected String[] getColumnsNames() {
        return new String[]{"Valor", "Comparação", "Pontuação", "Cor"};
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
            case 3:
                return metodoPontuacao.getCor() != null ? new Color(metodoPontuacao.getCor()) : null;
            default:
                return "";
        }
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        MetodoPontuacao metodoPontuacao = list.get(row);
        switch (column) {
            case 0:
                metodoPontuacao.setValor(Long.parseLong(aValue.toString()));
                break;
            case 1:
                metodoPontuacao.setComparacao(aValue.toString());
                break;
            case 2:
                metodoPontuacao.setPontuacao(Long.parseLong(aValue.toString()));
                break;
            case 3:
                metodoPontuacao.setCor(((Color) aValue).getRGB());
                break;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
            case 2:
                return Long.class;
            case 1:
                return String.class;
            case 3:
                return JLabel.class;
            default:
                return Object.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

}
