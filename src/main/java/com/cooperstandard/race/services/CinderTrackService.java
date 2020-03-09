package com.cooperstandard.race.services;

import com.cooperstandard.race.dal.repositories.KpiRepository;
import com.cooperstandard.race.frames.views.CinderTrack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinderTrackService {

    @Autowired
    private KpiRepository kpiRepository;

    public void initRacePanel(CinderTrack cinderTrack) {
        cinderTrack.initPanel(kpiRepository.findAll());
    }

}
