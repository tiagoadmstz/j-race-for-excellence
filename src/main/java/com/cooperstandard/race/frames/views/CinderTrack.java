package com.cooperstandard.race.frames.views;

import com.cooperstandard.race.frames.panels.CabecalhoPanel;
import com.cooperstandard.race.frames.panels.RacePanel;

import javax.swing.*;

/**
 * @author rsouza10
 */
public class CinderTrack extends javax.swing.JFrame {

    public CinderTrack() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        addObjects(new CabecalhoPanel(), new RacePanel());
    }

    private void addObjects(JComponent... components) {
        javax.swing.GroupLayout jpInputLayout = (GroupLayout) jpInput.getLayout();
        jpInputLayout.setHorizontalGroup(
                jpInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpInputLayout.createSequentialGroup()
                                .addGroup(addHorizontalGroups(jpInputLayout, components))
                                .addGap(0, 0, 0))
        );
        jpInputLayout.setVerticalGroup(
                jpInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(addVerticalGroups(jpInputLayout, components))
        );
    }

    private GroupLayout.ParallelGroup addHorizontalGroups(GroupLayout jpInputLayout, JComponent... components) {
        GroupLayout.ParallelGroup parallelGroup = jpInputLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
        for (JComponent component : components) {
            parallelGroup.addComponent(component, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        }
        return parallelGroup;
    }

    private GroupLayout.ParallelGroup addVerticalGroups(GroupLayout jpInputLayout, JComponent... components) {
        GroupLayout.ParallelGroup parallelGroup = jpInputLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
        for (JComponent component : components) {
            parallelGroup.addComponent(component, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
            if (components[components.length - 1] != component) parallelGroup.addGap(0, 0, 0);
        }
        return parallelGroup;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jpInput = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jpInput.setBackground(new java.awt.Color(226, 226, 226));
        jpInput.setMinimumSize(new java.awt.Dimension(200, 220));
        jpInput.setPreferredSize(new java.awt.Dimension(200, 220));

        javax.swing.GroupLayout jpInputLayout = new javax.swing.GroupLayout(jpInput);
        jpInput.setLayout(jpInputLayout);
        jpInputLayout.setHorizontalGroup(
                jpInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1241, Short.MAX_VALUE)
        );
        jpInputLayout.setVerticalGroup(
                jpInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 220, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jpInput);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1243, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CinderTrack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CinderTrack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CinderTrack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CinderTrack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CinderTrack().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpInput;
    // End of variables declaration//GEN-END:variables

}
