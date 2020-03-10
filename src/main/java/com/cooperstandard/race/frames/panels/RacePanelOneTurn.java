/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.race.frames.panels;

import com.cooperstandard.race.ui.IconThumbSliderUI;
import com.cooperstandard.race.util.ImageUtil;

import javax.swing.*;

/**
 * @author Tiago
 */
public class RacePanelOneTurn extends javax.swing.JPanel {

    private static final long serialVersionUID = -2521565115220757468L;

    /**
     * Creates new form RacePanel
     */
    public RacePanelOneTurn() {
        initComponents();
        addCinderTrack(jSlider1, "config/images/cars/ferrari.png");
    }

    public void setLabel(String label) {
        lbOee1.setText(label);
    }

    public void addCinderTrack(JSlider jslider, String imagePath) {
        ImageIcon imageIcon = ImageUtil.getImageIconFromUserPath(imagePath);
        IconThumbSliderUI iconThumbSliderUI = new IconThumbSliderUI(jslider, imageIcon, imageIcon);
        jslider.setUI(iconThumbSliderUI);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbOee1 = new javax.swing.JLabel();
        lbOeeMeta6 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();

        lbOee1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbOee1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbOee1.setText("OEE");
        lbOee1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbOeeMeta6.setBackground(new java.awt.Color(51, 255, 51));
        lbOeeMeta6.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        lbOeeMeta6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbOeeMeta6.setText("A");
        lbOeeMeta6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbOeeMeta6.setOpaque(true);
        lbOeeMeta6.setPreferredSize(new java.awt.Dimension(36, 36));

        jSlider1.setMajorTickSpacing(10);
        jSlider1.setMaximum(480);
        jSlider1.setPaintTrack(false);
        jSlider1.setValue(0);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbOee1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(lbOeeMeta6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSlider1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbOee1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbOeeMeta6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel lbOee1;
    private javax.swing.JLabel lbOeeMeta6;
    // End of variables declaration//GEN-END:variables
}
