package com.cooperstandard.race.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntradaKpiPontuacao implements Serializable {

    private static final long serialVersionUID = 6041155012364856673L;
    private String kpi;
    private Integer valor;

    public EntradaKpiPontuacao(String kpi) {
        this.kpi = kpi;
    }

    public static EntradaKpiPontuacao turnoToEntradaKpiPontuacao(String kpiNome, Turno turno) {
        return EntradaKpiPontuacao.builder()
                .kpi(kpiNome)
                .valor(turno.getTotalPontuacao().intValue())
                .build();
    }

}
