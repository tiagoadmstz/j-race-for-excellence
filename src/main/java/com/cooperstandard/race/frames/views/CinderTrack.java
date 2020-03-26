package com.cooperstandard.race.frames.views;

import com.cooperstandard.race.config.CooperstandardContext;
import com.cooperstandard.race.config.SpringContext;
import com.cooperstandard.race.frames.panels.CabecalhoPanel;
import com.cooperstandard.race.frames.panels.RacePanelTreeTurns;
import com.cooperstandard.race.listeners.CinderTrackListener;
import com.cooperstandard.race.models.Kpi;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rsouza10
 */
public class CinderTrack extends javax.swing.JFrame {

    public CinderTrack() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        new CinderTrackListener(this);
    }

    public void initPanel(List<Kpi> kpi) {
        Integer[] raceSize = SpringContext.getContext().getBean(CooperstandardContext.class).getRaceSize();
        JPanel mainPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS);

        mainPanel.setBackground(new Color(226, 226, 226));
        mainPanel.setMinimumSize(new Dimension(raceSize[0], raceSize[1]));
        mainPanel.setPreferredSize(new Dimension(raceSize[0], raceSize[1]));
        mainPanel.setLayout(boxLayout);
        mainPanel.add(new CabecalhoPanel());

        List<RacePanelTreeTurns> treeTurnsList = new ArrayList();
        kpi.stream().forEach(k -> {
            RacePanelTreeTurns racePanelTreeTurns = new RacePanelTreeTurns(k);
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
        pack();
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
