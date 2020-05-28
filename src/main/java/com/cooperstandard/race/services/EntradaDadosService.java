package com.cooperstandard.race.services;

import com.cooperstandard.race.dal.repositories.KpiRepository;
import com.cooperstandard.race.dal.repositories.TurnoRepository;
import com.cooperstandard.race.models.EntradaKpi;
import com.cooperstandard.race.models.EntradaKpiPontuacao;
import com.cooperstandard.race.models.MetodoPontuacao;
import com.cooperstandard.race.models.Pontuacao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class EntradaDadosService {

    private final KpiRepository kpiRepository;
    private final TurnoRepository turnoRepository;

    public void saveOrUpdate(EntradaKpi entradaKpi) {
        setPontuacaoReal(entradaKpi.getKpiPontuacao());
        Pontuacao.entradaKpiToPontuacao(entradaKpi)
                .forEach(pt ->
                        turnoRepository.findById(pt.getTurnoId())
                                .ifPresent(t -> {
                                    t.addPontuacao(pt);
                                    turnoRepository.save(t);
                                }));
        JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");
    }

    public void setPontuacaoReal(List<EntradaKpiPontuacao> entradaKpiPontuacaoList) {
        entradaKpiPontuacaoList.stream()
                .filter(etk -> etk.getEntrada() >= 0)
                .forEach(pontuacao -> {
                    Long pontos = kpiRepository.findByNome(pontuacao.getKpi())
                            .getMetodoPontuacao().stream()
                            .filter(mp -> mp.compararValores(pontuacao.getEntrada()) > 0)
                            .map(MetodoPontuacao::getPontuacao)
                            .findFirst().orElse(0L);
                    pontuacao.setValor(pontos.intValue());
                });
    }

    public List<EntradaKpiPontuacao> getKpiListByDataReferencia(String turno, LocalDate dataReferencia) {
        return kpiRepository.findByTurnosNomeAndTurnosPontuacaoDataRealizacao(turno, dataReferencia)
                .map(kpis -> kpis.stream().map(kpi -> EntradaKpiPontuacao.kpiToEntradaKpiPontuacao(kpi, turno, dataReferencia)).collect(Collectors.toList()))
                .orElseGet(() -> kpiRepository.findByTurnosNome(turno).stream()
                        .peek(kpi -> kpi.getTurnos().forEach(t -> t.setPontuacao(new ArrayList<>())))
                        .map(kpi -> EntradaKpiPontuacao.kpiToEntradaKpiPontuacao(kpi, turno, dataReferencia))
                        .collect(Collectors.toList())
                );
    }

}
