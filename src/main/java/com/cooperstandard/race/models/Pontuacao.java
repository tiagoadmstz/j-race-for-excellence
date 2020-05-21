package com.cooperstandard.race.models;

import com.cooperstandard.race.converters.LocalDateConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MOV_PONTUACAO_TURNO")
public class Pontuacao implements Serializable {

    private static final long serialVersionUID = -2091110799679025869L;
    @Id
    @Column(name = "PONTUACAO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "TURNO")
    private Long turnoId;
    @Convert(converter = LocalDateConverter.class)
    @Column(name = "DATA_REALIZACAO", columnDefinition = "date")
    private LocalDate dataRealizacao = LocalDate.now();
    @Column(name = "ENTRADA")
    private Float entrada = 0F;
    @Column(name = "PONTOS")
    private Integer pontos = 0;
    @Transient
    private String kpi;

    public static List<Pontuacao> entradaKpiToPontuacao(EntradaKpi entradaKpi) {
        return entradaKpi.getKpiPontuacao().stream()
                .map(pontuacao ->
                        Pontuacao.builder()
                                .dataRealizacao(entradaKpi.getDataReferencia())
                                .kpi(pontuacao.getKpi())
                                .entrada(pontuacao.getEntrada())
                                .pontos(pontuacao.getValor())
                                .build())
                .collect(Collectors.toList());
    }

}
