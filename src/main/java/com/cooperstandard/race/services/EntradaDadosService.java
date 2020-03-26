package com.cooperstandard.race.services;

import com.cooperstandard.race.dal.repositories.KpiRepository;
import com.cooperstandard.race.dal.repositories.PontuacaoRepository;
import com.cooperstandard.race.dal.repositories.TurnoRepository;
import com.cooperstandard.race.models.EntradaKpi;
import com.cooperstandard.race.models.EntradaKpiPontuacao;
import com.cooperstandard.race.models.Pontuacao;
import com.cooperstandard.race.util.ExecutionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class EntradaDadosService {

    private final PontuacaoRepository pontuacaoRepository;
    private final KpiRepository kpiRepository;
    private final TurnoRepository turnoRepository;

    public List<Pontuacao> saveOrUpdate(EntradaKpi entradaKpi) {
        return ExecutionUtil.trySelfExecution(() -> {
            List<Pontuacao> pontuacoes = pontuacaoRepository.saveAll(Pontuacao.entradaKpiToPontuario(entradaKpi).stream()
                    .map(pontuacao -> {
                        pontuacao.setTurno(kpiRepository.findByNome(pontuacao.getKpi()).getTurnos().stream()
                                .filter(turno -> entradaKpi.getTurno().equals(turno.getNome()))
                                .findFirst().get());
                        return pontuacao;
                    })
                    .collect(Collectors.toList()));
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");
            return pontuacoes;
        }, new ArrayList());
    }

    public List<EntradaKpiPontuacao> getKpiList() {
        return kpiRepository.findNomeAll().stream().map(kpi -> new EntradaKpiPontuacao(kpi)).collect(Collectors.toList());
    }

    public List<EntradaKpiPontuacao> getKpiListByDataReferencia(EntradaKpi entradaKpi, String turno) {
        return kpiRepository.findKpiByTurnosNomeAndTurnosPontuacaoDataRealizacao(entradaKpi.getTurno(), entradaKpi.getDataReferencia()).stream()
                .map(kpi -> EntradaKpiPontuacao.turnoToEntradaKpiPontuacao(kpi.getNome(), kpi.getTurnoByNome(turno)))
                .collect(Collectors.toList());
    }

}
