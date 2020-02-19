package com.cooperstandard.race;

import com.cooperstandard.race.enumerates.LOOKANDFEEL;
import com.cooperstandard.race.views.ViewKpi;

import javax.swing.*;

public class RaceForExcellenceApplication {

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        try {
            UIManager.setLookAndFeel(LOOKANDFEEL.WINDOWS_CLASSIC);
            new ViewKpi().setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
