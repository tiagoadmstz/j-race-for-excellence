package com.cooperstandard.race.services;

import com.cooperstandard.race.dal.repositories.KpiRepository;
import com.cooperstandard.race.dal.repositories.PontuacaoRepository;
import com.cooperstandard.race.frames.views.CinderTrack;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CinderTrackService {

    @Autowired
    private final KpiRepository kpiRepository;
    private final PontuacaoRepository pontuacaoRepository;

    public void initRacePanel(CinderTrack cinderTrack) {
        cinderTrack.initPanel(kpiRepository.findAll().stream().map(kpi -> {
            kpi.setTurnos(kpi.getTurnos().stream().map(turno -> {
                turno.setPontuacao(pontuacaoRepository.findByTurnoId(turno.getId()));
                return turno;
            }).collect(Collectors.toList()));
            return kpi;
        }).collect(Collectors.toList()));
    }

}
