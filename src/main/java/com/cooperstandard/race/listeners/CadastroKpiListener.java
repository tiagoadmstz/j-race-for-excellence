/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.race.listeners;

import com.cooperstandard.race.models.Meta;
import com.cooperstandard.race.models.Turno;
import com.cooperstandard.race.tables.editors.ColorCellEditor;
import com.cooperstandard.race.tables.models.MetaTableModel;
import com.cooperstandard.race.tables.models.TurnoTableModel;
import com.cooperstandard.race.tables.renderers.ColorCellRenderer;
import com.cooperstandard.race.views.CadastroKpi;

import java.awt.event.ActionEvent;

/**
 * @author Tiago
 */
public class CadastroKpiListener extends DefaultListenerCustom<CadastroKpi> {

    public CadastroKpiListener(CadastroKpi frame) {
        super(frame);
    }

    @Override
    protected void attachListeners() {
        frame.getButtonList().forEach(bt -> bt.addActionListener(this));
    }

    @Override
    protected void initTable() {
        frame.getTbMetasVinculadas().setModel(new MetaTableModel());
        frame.getTbMetasVinculadas().getColumnModel().getColumn(3).setCellRenderer(new ColorCellRenderer());
        frame.getTbMetasVinculadas().getColumnModel().getColumn(3).setCellEditor(new ColorCellEditor());
        frame.getTbTurnos().setModel(new TurnoTableModel());
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand().toLowerCase()) {
            case "adicionarmeta":
                addMeta();
                break;
            case "excluirmeta":
                break;
            case "adicionarturno":
                addTurno();
                break;
            case "excluirturno":
                break;
            case "save":
                save();
                break;
            case "update":
                update();
                break;
            case "search":
                search();
                break;
        }
    }

    public void addMeta() {
        frame.getTbMetasVinculadasModel().addObject(new Meta());
    }

    public void deleteMeta(){
        frame.getTbMetasVinculadasModel().removeObject(frame.getTbMetasVinculadasModel().getSelectedObject());
    }

    public void addTurno() {
        frame.getTbTurnosModel().addObject(new Turno());
    }

    public void save() {

    }

    public void update() {

    }

    public void search() {

    }

}
