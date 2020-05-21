package com.cooperstandard.race.listeners;

import com.cooperstandard.race.config.SpringContext;
import com.cooperstandard.race.frames.views.EntradaDadosKpi;
import com.cooperstandard.race.interfaces.CrudListener;
import com.cooperstandard.race.interfaces.DefaultListenerCustom;
import com.cooperstandard.race.models.EntradaKpiPontuacao;
import com.cooperstandard.race.services.EntradaDadosService;
import com.cooperstandard.race.tables.models.PontuacaoTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.List;

public class EntradaDadosKpiListener extends DefaultListenerCustom<EntradaDadosKpi> implements CrudListener {

    private EntradaDadosService entradaDadosService;

    public EntradaDadosKpiListener(EntradaDadosKpi frame) {
        super(frame);
    }

    @Override
    protected void initComponents() {
        super.initComponents();
        pesquisarLancamentoDia();
    }

    @Override
    protected void attachListeners() {
        frame.getButtonList().forEach(bt -> bt.addActionListener(this));
        frame.getTxtDataReferencia().addFocusListener(focusDataReferencia());
    }

    @Override
    protected void initTable() {
        if (entradaDadosService == null)
            entradaDadosService = SpringContext.getContext().getBean(EntradaDadosService.class);
        //frame.getTbKpisAtivos().setCellEditor(new CheckBoxCellEditor());
        //frame.getTbKpisAtivos().getColumnModel().getColumn(1).setCellRenderer(new CheckBoxRenderer());
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

    private void pesquisarLancamentoDia() {
        List<EntradaKpiPontuacao> kpiListByDataReferencia = entradaDadosService.getKpiListByDataReferencia(frame.getEntradaKpi(), frame.getSelectedTurno());
        if (kpiListByDataReferencia != null & !kpiListByDataReferencia.isEmpty())
            frame.getTbKpisAtivosModel().setList(kpiListByDataReferencia);
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
