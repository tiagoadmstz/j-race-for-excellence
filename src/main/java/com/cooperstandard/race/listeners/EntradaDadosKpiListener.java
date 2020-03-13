package com.cooperstandard.race.listeners;

import com.cooperstandard.race.config.SpringContext;
import com.cooperstandard.race.frames.views.EntradaDadosKpi;
import com.cooperstandard.race.interfaces.CrudListener;
import com.cooperstandard.race.interfaces.DefaultListenerCustom;
import com.cooperstandard.race.services.EntradaDadosService;
import com.cooperstandard.race.tables.models.PontuacaoTableModel;

import java.awt.event.ActionEvent;

public class EntradaDadosKpiListener extends DefaultListenerCustom<EntradaDadosKpi> implements CrudListener {

    private EntradaDadosService entradaDadosService;

    public EntradaDadosKpiListener(EntradaDadosKpi frame) {
        super(frame);
    }

    @Override
    protected void attachListeners() {
        frame.getButtonList().forEach(bt -> bt.addActionListener(this));
    }

    @Override
    protected void initTable() {
        if (entradaDadosService == null)
            entradaDadosService = SpringContext.getContext().getBean(EntradaDadosService.class);
        frame.getTbKpisAtivos().setModel(new PontuacaoTableModel(entradaDadosService.getKpiList()));
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (actionPerformance(event.getActionCommand().toLowerCase())) {
            case "":
                break;
        }
    }

    @Override
    public void saveOrUpdate() {
        entradaDadosService.saveOrUpdate(frame.getEntradaKpi());
    }

    @Override
    public void delete() {

    }

    @Override
    public void search() {

    }

}
