/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.race.frames.views;

import br.com.dev.engine.date.Datas;
import com.cooperstandard.race.listeners.EntradaDadosKpiListener;
import com.cooperstandard.race.models.EntradaKpi;
import com.cooperstandard.race.tables.models.PontuacaoTableModel;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tiago
 */
public class EntradaDadosKpi extends javax.swing.JFrame {

    /**
     * Creates new form EntradaDadosKpi
     */
    public EntradaDadosKpi() {
        initComponents();
        new EntradaDadosKpiListener(this);
    }

    public List<AbstractButton> getButtonList() {
        return Arrays.asList(btSalvar, btAtualizar, btPesquisar);
    }

    public JTable getTbKpisAtivos() {
        return tbKpisAtivos;
    }

    public JTextField getTxtDataReferencia() {
        return txtDataReferencia;
    }

    public LocalDate getDataReferencia() {
        txtDataReferencia.setText(Datas.getDateString(txtDataReferencia.getText(), 1));
        return !"".equals(txtDataReferencia.getText()) ? Datas.stringToLocalDate(txtDataReferencia.getText()) : null;
    }

    public PontuacaoTableModel getTbKpisAtivosModel() {
        return (PontuacaoTableModel) tbKpisAtivos.getModel();
    }

    public EntradaKpi getEntradaKpi() {
        return EntradaKpi.builder()
                .dataReferencia(Datas.stringToLocalDate(txtDataReferencia.getText()))
                .turno(cbTurno.getSelectedItem().toString())
                .kpiPontuacao(getTbKpisAtivosModel().getList())
                .build();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbConferenciaValores = new javax.swing.JLabel();
        txtDataReferencia = new javax.swing.JTextField();
        cbTurno = new javax.swing.JComboBox<>();
        scKpisAtivos = new javax.swing.JScrollPane();
        tbKpisAtivos = new javax.swing.JTable();
        btSalvar = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Entrada de Dados de KPI");

        jLabel1.setText("Kpis Ativos");

        jLabel2.setText("Data de referência");

        jLabel3.setText("Turno");

        lbConferenciaValores.setForeground(new java.awt.Color(255, 0, 0));
        lbConferenciaValores.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbConferenciaValores.setText(",./*");

        txtDataReferencia.setPreferredSize(new java.awt.Dimension(111, 20));

        cbTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"A", "B", "C"}));
        cbTurno.setPreferredSize(new java.awt.Dimension(111, 22));

        tbKpisAtivos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "KPI", "Valor"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        scKpisAtivos.setViewportView(tbKpisAtivos);

        btSalvar.setText("Salvar");
        btSalvar.setActionCommand("save");
        btSalvar.setPreferredSize(new java.awt.Dimension(80, 23));

        btAtualizar.setText("Atualizar");
        btAtualizar.setActionCommand("update");
        btAtualizar.setPreferredSize(new java.awt.Dimension(80, 23));

        btPesquisar.setText("Pesquisar");
        btPesquisar.setActionCommand("search");
        btPesquisar.setPreferredSize(new java.awt.Dimension(80, 23));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(scKpisAtivos)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtDataReferencia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(cbTurno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lbConferenciaValores, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addGap(5, 5, 5)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtDataReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cbTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lbConferenciaValores))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scKpisAtivos, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> cbTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbConferenciaValores;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane scKpisAtivos;
    private javax.swing.JTable tbKpisAtivos;
    private javax.swing.JTextField txtDataReferencia;
    // End of variables declaration//GEN-END:variables
}
