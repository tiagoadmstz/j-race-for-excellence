/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.race.tables.models;

import com.cooperstandard.race.models.Meta;
import com.cooperstandard.race.tables.interfaces.DefaultTableModelCustom;

import javax.swing.*;
import java.awt.*;

/**
 * @author Tiago
 */
public class MetaTableModel extends DefaultTableModelCustom<Meta> {

    @Override
    protected String[] getColumnsNames() {
        return new String[]{"Valor", "Comparação", "Pontuação", "Cor"};
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Meta meta = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return meta.getValor();
            case 1:
                return meta.getComparacao();
            case 2:
                return meta.getPontuacao();
            case 3:
                return meta.getCor() != null ? new Color(meta.getCor()) : null;
            default:
                return "";
        }
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        Meta meta = list.get(row);
        switch (column) {
            case 0:
                meta.setValor(Long.parseLong(aValue.toString()));
                break;
            case 1:
                meta.setComparacao(aValue.toString());
                break;
            case 2:
                meta.setPontuacao(Long.parseLong(aValue.toString()));
                break;
            case 3:
                meta.setCor(((Color) aValue).getRGB());
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
