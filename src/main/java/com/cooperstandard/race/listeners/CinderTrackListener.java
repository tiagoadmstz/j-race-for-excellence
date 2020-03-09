/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.race.listeners;

import com.cooperstandard.race.config.SpringContext;
import com.cooperstandard.race.frames.views.CinderTrack;
import com.cooperstandard.race.interfaces.DefaultListenerCustom;
import com.cooperstandard.race.services.CinderTrackService;

import java.awt.event.ActionEvent;

/**
 * @author Tiago
 */
public class CinderTrackListener extends DefaultListenerCustom<CinderTrack> {

    private CinderTrackService cinderTrackService;

    public CinderTrackListener(CinderTrack frame) {
        super(frame);
    }

    @Override
    protected void initComponents() {
        super.initComponents();
        initRace();
    }

    private void initRace() {
        if (cinderTrackService == null)
            cinderTrackService = SpringContext.getContext().getBean(CinderTrackService.class);
        cinderTrackService.initRacePanel(frame);
    }

    @Override
    protected void attachListeners() {

    }

    @Override
    protected void initTable() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
