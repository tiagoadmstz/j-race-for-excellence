package com.cooperstandard.race.services;

import com.cooperstandard.race.dal.repositories.CorridaRepository;
import com.cooperstandard.race.frames.views.CinderTrack;
import com.cooperstandard.race.models.Corrida;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CinderTrackService {

    @Autowired
    private final CorridaRepository corridaRepository;

    public void initRacePanel(CinderTrack cinderTrack) {
        Optional<Corrida> corridaOptional = corridaRepository.findById(1L);
        if (corridaOptional.isPresent()) {
            Corrida corrida = corridaOptional.get();
            cinderTrack.initPanel(corrida.getMeta().intValue(), corrida.getKpis());
        }
    }

}
