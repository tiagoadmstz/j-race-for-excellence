package com.cooperstandard.race.frames.views;

import com.cooperstandard.race.config.CooperstandardContext;
import com.cooperstandard.race.config.SpringContext;
import com.cooperstandard.race.dal.repositories.KpiRepository;
import com.cooperstandard.race.dal.repositories.PontuacaoRepository;
import com.cooperstandard.race.frames.panels.CabecalhoPanel;
import com.cooperstandard.race.frames.panels.RacePanelTreeTurns;
import com.cooperstandard.race.listeners.CinderTrackListener;
import com.cooperstandard.race.models.Kpi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author rsouza10
 */
public class CinderTrack extends javax.swing.JFrame {

    private final List<RacePanelTreeTurns> treeTurnsList = new ArrayList();
    private CooperstandardContext cooperstandardContext;
    private boolean activeUpdates;

    public CinderTrack() {
        cooperstandardContext = SpringContext.getContext().getBean(CooperstandardContext.class);
        setIconImage(cooperstandardContext.getIcon());
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        activeUpdates = cooperstandardContext.getRaceUpdates();
        new CinderTrackListener(this);
    }

    public void initPanel(int meta, List<Kpi> kpi) {
        Integer[] raceSize = SpringContext.getContext().getBean(CooperstandardContext.class).getRaceSize();
        JPanel mainPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS);

        mainPanel.setBackground(new Color(226, 226, 226));
        mainPanel.setMinimumSize(new Dimension(raceSize[0], raceSize[1]));
        mainPanel.setPreferredSize(new Dimension(raceSize[0], raceSize[1]));
        mainPanel.setLayout(boxLayout);
        mainPanel.add(new CabecalhoPanel());

        kpi.stream().forEach(k -> {
            RacePanelTreeTurns racePanelTreeTurns = new RacePanelTreeTurns(meta, k);
            treeTurnsList.add(racePanelTreeTurns);
            mainPanel.add(racePanelTreeTurns);
        });

        new Thread(() -> {
            try {
                Thread.sleep(500L);
                treeTurnsList.forEach(panel -> panel.startRace());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }).start();

        scMain.getViewport().setSize(mainPanel.getWidth(), mainPanel.getHeight());
        scMain.setViewportView(mainPanel);
        activeActualValues();
        pack();
    }

    public void activeActualValues() {
        new Thread(() -> {
            try {
                Float sleepTime = 1000L * cooperstandardContext.getRaceUpdatesTime();
                while (activeUpdates) {
                    Thread.sleep(sleepTime.longValue());
                    treeTurnsList.forEach(panel -> {
                        Kpi kpi = SpringContext.getContext().getBean(KpiRepository.class).findByNome(panel.getName());
                        kpi.setTurnos(kpi.getTurnos().stream().map(turno -> {
                            turno.setPontuacao(SpringContext.getContext().getBean(PontuacaoRepository.class).findByTurnoId(turno.getId()));
                            return turno;
                        }).collect(Collectors.toList()));
                        panel.setActualValue(kpi);
                    });
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }).start();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                activeUpdates = false;
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scMain = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        scMain.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scMain.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scMain, javax.swing.GroupLayout.DEFAULT_SIZE, 1243, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scMain)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scMain;
    // End of variables declaration//GEN-END:variables

}
