package com.cooperstandard.race;

import com.cooperstandard.race.enumerates.LOOKANDFEEL;
import com.cooperstandard.race.frames.views.CinderTrack;

import javax.swing.*;

public class RaceForExcellenceApplication {

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        try {
            UIManager.setLookAndFeel(LOOKANDFEEL.WINDOWS_CLASSIC);
            CinderTrack cinderTrack = new CinderTrack();
            cinderTrack.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
