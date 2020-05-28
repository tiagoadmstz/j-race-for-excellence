package com.cooperstandard.race.models;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

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
    private Float entrada = -1F;
    private Integer valor = 0;

    public EntradaKpiPontuacao(String kpi, String tipoEntrada) {
        this.kpi = kpi;
        this.tipoEntrada = tipoEntrada;
    }

    public static EntradaKpiPontuacao kpiToEntradaKpiPontuacao(Kpi kpi, String turno, LocalDate dateRealizacao) {
        Turno trn = kpi.getTurnos() != null & !kpi.getTurnos().isEmpty()
                ? kpi.getTurnos().stream().filter(t -> turno.equals(t.getNome())).findFirst().get()
                : null;
        Pontuacao pontuacao = trn.getPontuacao() != null & !trn.getPontuacao().isEmpty()
                ? trn.getPontuacao().stream().filter(pt -> dateRealizacao.isEqual(pt.getDataRealizacao())).findFirst().orElse(null)
                : null;
        return EntradaKpiPontuacao.builder()
                .turnoId(trn.getId())
                .kpi(kpi.getNome())
                .pontuacaoId(pontuacao != null ? pontuacao.getId() : null)
                .tipoEntrada(kpi.getTipoEntrada())
                .entrada(pontuacao != null ? pontuacao.getEntrada() : -1F)
                .valor(pontuacao != null ? pontuacao.getPontos() : 0)
                .build();
    }

}
