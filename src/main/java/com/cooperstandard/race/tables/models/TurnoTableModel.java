package com.cooperstandard.race.tables.models;

import com.cooperstandard.race.models.Turno;
import com.cooperstandard.race.tables.interfaces.DefaultTableModelCustom;

public class TurnoTableModel extends DefaultTableModelCustom<Turno> {

    @Override
    protected String[] getColumnsNames() {
        return new String[]{"Nome", "Ordem", "Carro"};
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Turno turno = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return turno.getNome();
            case 1:
                return turno.getOrdem();
            case 2:
                return turno.getCarro();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Turno turno = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                turno.setNome(aValue.toString());
                break;
            case 1:
                turno.setOrdem(Integer.parseInt(aValue.toString()));
                break;
            case 2:
                turno.setCarro(aValue.toString());
                break;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
            case 2:
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
