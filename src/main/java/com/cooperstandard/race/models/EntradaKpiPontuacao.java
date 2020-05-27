package com.cooperstandard.race.models;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class EntradaKpiPontuacao implements Serializable {

    private static final long serialVersionUID = 6041155012364856673L;
    private Long turnoId;
    private String kpi;
    private String tipoEntrada;
    private Long pontuacaoId;
    private Float entrada = 0F;
    private Integer valor = 0;

    public EntradaKpiPontuacao(String kpi, String tipoEntrada) {
        this.kpi = kpi;
        this.tipoEntrada = tipoEntrada;
    }

    public static EntradaKpiPontuacao kpiToEntradaKpiPontuacao(Kpi kpi) {
        Turno turno = kpi.getTurnos() != null & !kpi.getTurnos().isEmpty() ? kpi.getTurnos().get(0) : null;
        Pontuacao pontuacao = turno.getPontuacao() != null & !turno.getPontuacao().isEmpty() ? turno.getPontuacao().get(0) : null;
        return EntradaKpiPontuacao.builder()
                .turnoId(turno.getId())
                .kpi(kpi.getNome())
                .pontuacaoId(pontuacao != null ? pontuacao.getId() : null)
                .tipoEntrada(kpi.getTipoEntrada())
                .entrada(pontuacao != null ? pontuacao.getEntrada() : 0F)
                .valor(pontuacao != null ? pontuacao.getPontos() : 0)
                .build();
    }

}
