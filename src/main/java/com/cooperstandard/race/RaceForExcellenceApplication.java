package com.cooperstandard.race;

import com.cooperstandard.race.config.CooperstandardContext;
import com.cooperstandard.race.config.SpringContext;
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
            if ("dev".equals(SpringContext.getContext().getBean(CooperstandardContext.class).getProfile())) {
                new DummyData();
            }
            UIManager.setLookAndFeel(LOOKANDFEEL.WINDOWS_CLASSIC);
            new ViewLoading().setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
