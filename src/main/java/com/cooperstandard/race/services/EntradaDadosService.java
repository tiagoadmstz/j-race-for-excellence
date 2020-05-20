package com.cooperstandard.race.services;

import com.cooperstandard.race.dal.repositories.KpiRepository;
import com.cooperstandard.race.dal.repositories.PontuacaoRepository;
import com.cooperstandard.race.models.EntradaKpi;
import com.cooperstandard.race.models.EntradaKpiPontuacao;
import com.cooperstandard.race.models.MetodoPontuacao;
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

    public List<Pontuacao> saveOrUpdate(EntradaKpi entradaKpi) {
        return ExecutionUtil.trySelfExecution(() -> {
            setPontuacaoReal(entradaKpi.getKpiPontuacao());
            List<Pontuacao> pontuacaoList = Pontuacao.entradaKpiToPontuario(entradaKpi).stream()
                    .map(pontuacao -> {
                        pontuacao.setTurnoId(kpiRepository.findByNome(pontuacao.getKpi()).getTurnos().stream()
                                .filter(turno -> entradaKpi.getTurno().equals(turno.getNome()))
                                .findFirst().get().getId());
                        return pontuacao;
                    })
                    .collect(Collectors.toList());
            List<Pontuacao> pontuacoes = pontuacaoRepository.saveAll(pontuacaoList);
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");
            return pontuacoes;
        }, new ArrayList());
    }

    public void setPontuacaoReal(List<EntradaKpiPontuacao> entradaKpiPontuacaoList) {
        entradaKpiPontuacaoList.stream().filter(ekp -> ekp.getValor() > 0).forEach(pontuacao -> {
            Long pontos = kpiRepository.findByNome(pontuacao.getKpi()).getMetodoPontuacao().stream().filter(mp -> mp.compararValores(pontuacao.getValor()) > 0).map(MetodoPontuacao::getPontuacao).findFirst().orElse(0L);
            pontuacao.setValorReal(pontos.intValue());
        });
    }

    public List<EntradaKpiPontuacao> getKpiList() {
        return kpiRepository.findAll().stream().map(kpi -> new EntradaKpiPontuacao(kpi.getNome(), kpi.getTipoEntrada())).collect(Collectors.toList());
    }

    public List<EntradaKpiPontuacao> getKpiListByDataReferencia(EntradaKpi entradaKpi, String turno) {
        return kpiRepository.findAll().stream()
                .filter(kpi -> kpi.getTurnos().stream().anyMatch(t -> turno.equals(t.getNome()) && t.getPontuacao().stream().anyMatch(p -> entradaKpi.getDataReferencia().equals(p.getDataRealizacao()))))
                .map(kpi -> EntradaKpiPontuacao.turnoToEntradaKpiPontuacao(kpi.getNome(), kpi.getTipoEntrada()))
                .collect(Collectors.toList());
    }

}
