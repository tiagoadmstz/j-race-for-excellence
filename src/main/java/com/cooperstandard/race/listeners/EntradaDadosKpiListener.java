package com.cooperstandard.race.listeners;

import com.cooperstandard.race.config.SpringContext;
import com.cooperstandard.race.frames.views.EntradaDadosKpi;
import com.cooperstandard.race.interfaces.CrudListener;
import com.cooperstandard.race.interfaces.DefaultListenerCustom;
import com.cooperstandard.race.models.EntradaKpiPontuacao;
import com.cooperstandard.race.services.EntradaDadosService;
import com.cooperstandard.race.tables.models.PontuacaoTableModel;

import java.awt.event.*;
import java.time.LocalDate;
import java.util.List;

public class EntradaDadosKpiListener extends DefaultListenerCustom<EntradaDadosKpi> implements CrudListener {

    private EntradaDadosService entradaDadosService;

    public EntradaDadosKpiListener(EntradaDadosKpi frame) {
        super(frame);
    }

    @Override
    protected void initComponents() {
        super.initComponents();
    }

    @Override
    protected void attachListeners() {
        frame.getButtonList().forEach(bt -> bt.addActionListener(this));
        frame.getTxtDataReferencia().addFocusListener(focusDataReferencia());
        frame.getCbTurno().addItemListener(selectionTurno());
    }

    @Override
    protected void initTable() {
        if (entradaDadosService == null)
            entradaDadosService = SpringContext.getContext().getBean(EntradaDadosService.class);
        frame.getTbKpisAtivos().setModel(new PontuacaoTableModel(entradaDadosService.getKpiListByDataReferencia(frame.getSelectedTurno(), LocalDate.now())));
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
        pesquisarLancamentoDia();
    }

    @Override
    public void delete() {

    }

    @Override
    public void search() {

    }

    private void pesquisarLancamentoDia() {
        List<EntradaKpiPontuacao> kpiListByDataReferencia = entradaDadosService.getKpiListByDataReferencia(frame.getSelectedTurno(), frame.getDataReferencia());
        frame.getTbKpisAtivosModel().setList(kpiListByDataReferencia);
    }

    public ItemListener selectionTurno() {
        return new ItemListener() {
            private String turno = "A";

            @Override
            public void itemStateChanged(ItemEvent event) {
                if (!turno.equals(event.getItem())) {
                    turno = event.getItem().toString();
                    pesquisarLancamentoDia();
                }
            }
        };
    }

    public FocusAdapter focusDataReferencia() {
        return new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent event) {
                pesquisarLancamentoDia();
            }
        };
    }

}
