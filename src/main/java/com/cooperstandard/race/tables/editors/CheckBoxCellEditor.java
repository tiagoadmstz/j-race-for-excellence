package com.cooperstandard.race.tables.editors;

import com.cooperstandard.race.tables.models.PontuacaoTableModel;

import javax.swing.*;
import java.awt.*;

public class CheckBoxCellEditor extends DefaultCellEditor {

    public CheckBoxCellEditor() {
        super(new JCheckBox());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PontuacaoTableModel model = (PontuacaoTableModel) table.getModel();
        if ("sim e não".equalsIgnoreCase(model.getList().get(row).getTipoEntrada())) {
            table.getColumnModel().getColumn(column).setCellEditor(new DefaultCellEditor(new JCheckBox()));
        }
        return super.getTableCellEditorComponent(table, value, isSelected, row, column);
    }

}
