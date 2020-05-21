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
    private String tipoEntrada;
    private Float entrada = 0F;
    private Integer valor = 0;

    public EntradaKpiPontuacao(String kpi, String tipoEntrada) {
        this.kpi = kpi;
        this.tipoEntrada = tipoEntrada;
    }

    public static EntradaKpiPontuacao turnoToEntradaKpiPontuacao(String kpiNome, String tipoEntrada, Float entrada) {
        return EntradaKpiPontuacao.builder()
                .kpi(kpiNome)
                .tipoEntrada(tipoEntrada)
                .entrada(entrada)
                .build();
    }

}
