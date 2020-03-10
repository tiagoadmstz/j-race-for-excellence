package com.cooperstandard.race;

import com.cooperstandard.race.dal.DummyData;
import com.cooperstandard.race.enumerates.LOOKANDFEEL;
import com.cooperstandard.race.frames.views.ViewLoading;

import javax.swing.*;

public class RaceForExcellenceApplication {

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        try {
            new DummyData();
            UIManager.setLookAndFeel(LOOKANDFEEL.WINDOWS_CLASSIC);
            new ViewLoading().setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
