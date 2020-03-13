package com.cooperstandard.race.tables.models;

import com.cooperstandard.race.models.EntradaKpiPontuacao;
import com.cooperstandard.race.tables.interfaces.DefaultTableModelCustom;

import java.util.List;

public class PontuacaoTableModel extends DefaultTableModelCustom<EntradaKpiPontuacao> {

    public PontuacaoTableModel() {
    }

    public PontuacaoTableModel(List<EntradaKpiPontuacao> list) {
        super(list);
    }

    @Override
    protected String[] getColumnsNames() {
        return new String[]{"KPI", "Valor"};
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        EntradaKpiPontuacao pontuacao = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pontuacao.getKpi();
            case 1:
                return pontuacao.getValor();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        EntradaKpiPontuacao pontuacao = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                pontuacao.setKpi(aValue != null ? aValue.toString() : null);
                break;
            case 1:
                pontuacao.setValor(aValue != null ? Integer.parseInt(aValue.toString()) : null);
                break;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Integer.class;
            default:
                return Object.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

}
