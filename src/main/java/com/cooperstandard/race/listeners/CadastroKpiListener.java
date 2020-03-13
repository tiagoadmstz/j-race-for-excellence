/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.race.listeners;

import com.cooperstandard.race.config.SpringContext;
import com.cooperstandard.race.frames.views.CadastroKpi;
import com.cooperstandard.race.interfaces.CrudListener;
import com.cooperstandard.race.interfaces.DefaultListenerCustom;
import com.cooperstandard.race.models.Kpi;
import com.cooperstandard.race.models.MetodoPontuacao;
import com.cooperstandard.race.models.Turno;
import com.cooperstandard.race.services.CadastroKpiService;
import com.cooperstandard.race.tables.models.MetaTableModel;
import com.cooperstandard.race.tables.models.TurnoTableModel;

import java.awt.event.ActionEvent;

/**
 * @author Tiago
 */
public class CadastroKpiListener extends DefaultListenerCustom<CadastroKpi> implements CrudListener {

    private final CadastroKpiService kpiService;

    public CadastroKpiListener(CadastroKpi frame) {
        super(frame);
        kpiService = SpringContext.getContext().getBean(CadastroKpiService.class);
    }

    @Override
    protected void attachListeners() {
        frame.getButtonList().forEach(bt -> bt.addActionListener(this));
    }

    @Override
    protected void initTable() {
        frame.getTbMetasVinculadas().setModel(new MetaTableModel());
        frame.getTbTurnos().setModel(new TurnoTableModel());
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (actionPerformance(event.getActionCommand().toLowerCase())) {
            case "addmeta":
                addMeta();
                break;
            case "deletemeta":
                deleteMeta();
                break;
            case "addturno":
                addTurno();
                break;
            case "deleteturno":
                deleteTurno();
                break;
        }
    }

    public void addMeta() {
        frame.getTbMetasVinculadasModel().addObject(new MetodoPontuacao());
    }

    public void deleteMeta() {
        frame.getTbMetasVinculadasModel().removeObjects(frame.getTbMetasVinculadas().getSelectedRows());
    }

    public void addTurno() {
        frame.getTbTurnosModel().addObject(new Turno());
    }

    public void deleteTurno() {
        frame.getTbTurnosModel().removeObjects(frame.getTbTurnos().getSelectedRows());
    }

    @Override
    public void saveOrUpdate() {
        kpiService.saveOrUpdate(frame.getKpi());
    }

    @Override
    public void delete() {

    }

    @Override
    public void search() {

    }

}
