/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.race.frames.views;

import com.cooperstandard.race.listeners.CadastroKpiListener;
import com.cooperstandard.race.models.Kpi;
import com.cooperstandard.race.tables.models.MetodoPontuacaoTableModel;
import com.cooperstandard.race.tables.models.TurnoTableModel;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tiago
 */
public class CadastroKpi extends javax.swing.JFrame {

    /**
     * Creates new form CadastroKpi
     */
    public CadastroKpi() {
        initComponents();
        new CadastroKpiListener(this);
    }

    public List<AbstractButton> getButtonList() {
        return Arrays.asList(btAdicionarMeta, btExcluirMeta, btAdicionarTurno, btExcluirTurno, btSalvar, btAtualizar, btPesquisar, btSelecionarCarro);
    }

    public Kpi getKpi() {
        return Kpi.builder()
                .ativo(ckAtivo.isSelected())
                .nome(txtNomeKpi.getText())
                .metodoPontuacao(getTbMetasVinculadasModel().getList())
                .turnos(getTbTurnosModel().getList())
                .build();
    }

    public void setKpi(Kpi kpi) {
        ckAtivo.setSelected(kpi.getAtivo());
        txtNomeKpi.setText(kpi.getNome());
        getTbMetasVinculadasModel().setList(kpi.getMetodoPontuacao());
        getTbTurnosModel().setList(kpi.getTurnos());
    }

    public void clear() {
        ckAtivo.setSelected(true);
        txtNomeKpi.setText("");
        lbCarro.setIcon(null);
        cbTipoEntrada.setSelectedIndex(-1);
        getTbMetasVinculadasModel().clear();
        getTbTurnosModel().clear();
    }

    public JLabel getLbCarro() {
        return lbCarro;
    }

    public JTable getTbMetasVinculadas() {
        return tbMetasVinculadas;
    }

    public JTable getTbTurnos() {
        return tbTurnos;
    }

    public MetodoPontuacaoTableModel getTbMetasVinculadasModel() {
        return (MetodoPontuacaoTableModel) tbMetasVinculadas.getModel();
    }

    public TurnoTableModel getTbTurnosModel() {
        return (TurnoTableModel) tbTurnos.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNomeKpi = new javax.swing.JTextField();
        cbTipoEntrada = new javax.swing.JComboBox<>();
        ckAtivo = new javax.swing.JCheckBox();
        lbCarro = new javax.swing.JLabel();
        btAdicionarMeta = new javax.swing.JButton();
        btExcluirMeta = new javax.swing.JButton();
        scMetasVinculadas = new javax.swing.JScrollPane();
        tbMetasVinculadas = new javax.swing.JTable();
        btAdicionarTurno = new javax.swing.JButton();
        btExcluirTurno = new javax.swing.JButton();
        scTurnos = new javax.swing.JScrollPane();
        tbTurnos = new javax.swing.JTable();
        btSalvar = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();
        btSelecionarCarro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Key Performance Indicator");

        jLabel1.setText("Nome do KPI");

        jLabel2.setText("Metas vinculadas");

        jLabel3.setText("Tipo de entrada de dados");

        jLabel5.setText("Turnos");

        cbTipoEntrada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Porcentagem", "Minutos", "Sim e Não", "Unidade"}));

        ckAtivo.setText("Ativo");

        lbCarro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCarro.setToolTipText("Carro");

        btAdicionarMeta.setText("Adicionar");
        btAdicionarMeta.setActionCommand("addMeta");
        btAdicionarMeta.setPreferredSize(new java.awt.Dimension(80, 23));

        btExcluirMeta.setText("Excluir");
        btExcluirMeta.setActionCommand("deleteMeta");
        btExcluirMeta.setPreferredSize(new java.awt.Dimension(80, 23));

        tbMetasVinculadas.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Valor", "Comparação", "Pontuação"
                }
        ));
        scMetasVinculadas.setViewportView(tbMetasVinculadas);

        btAdicionarTurno.setText("Adicionar");
        btAdicionarTurno.setActionCommand("addTurno");
        btAdicionarTurno.setPreferredSize(new java.awt.Dimension(80, 23));

        btExcluirTurno.setText("Excluir");
        btExcluirTurno.setActionCommand("deleteTurno");
        btExcluirTurno.setPreferredSize(new java.awt.Dimension(80, 23));

        tbTurnos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Nome", "Ordem", "Carro"
                }
        ));
        scTurnos.setViewportView(tbTurnos);

        btSalvar.setText("Salvar");
        btSalvar.setActionCommand("save");
        btSalvar.setPreferredSize(new java.awt.Dimension(80, 23));

        btAtualizar.setText("Atualizar");
        btAtualizar.setActionCommand("update");
        btAtualizar.setPreferredSize(new java.awt.Dimension(80, 23));

        btPesquisar.setText("Pesquisar");
        btPesquisar.setActionCommand("search");
        btPesquisar.setPreferredSize(new java.awt.Dimension(80, 23));

        btSelecionarCarro.setText("Selecionar Carro");
        btSelecionarCarro.setActionCommand("selecionarCarro");
        btSelecionarCarro.setPreferredSize(new java.awt.Dimension(80, 23));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addComponent(btSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtNomeKpi)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                                .addComponent(ckAtivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(115, 115, 115))
                                        .addComponent(cbTipoEntrada, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbCarro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addComponent(btAdicionarMeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(152, 152, 152)
                                                .addComponent(btExcluirMeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addComponent(btAdicionarTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btSelecionarCarro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btExcluirTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(scTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scMetasVinculadas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(btAdicionarMeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btExcluirMeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(scMetasVinculadas, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btAdicionarTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btExcluirTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btSelecionarCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(scTurnos, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addComponent(txtNomeKpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbTipoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(5, 5, 5)
                                                .addComponent(ckAtivo)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbCarro, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                                                .addGap(9, 9, 9)
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionarMeta;
    private javax.swing.JButton btAdicionarTurno;
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btExcluirMeta;
    private javax.swing.JButton btExcluirTurno;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btSelecionarCarro;
    private javax.swing.JComboBox<String> cbTipoEntrada;
    private javax.swing.JCheckBox ckAtivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbCarro;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane scMetasVinculadas;
    private javax.swing.JScrollPane scTurnos;
    private javax.swing.JTable tbMetasVinculadas;
    private javax.swing.JTable tbTurnos;
    private javax.swing.JTextField txtNomeKpi;
    // End of variables declaration//GEN-END:variables
}
