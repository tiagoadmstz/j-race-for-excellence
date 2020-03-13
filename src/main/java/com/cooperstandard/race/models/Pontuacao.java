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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TURNO_ID", referencedColumnName = "TURNO")
    private Turno turno;
    @Convert(converter = LocalDateConverter.class)
    @Column(name = "DATA_REALIZACAO")
    private LocalDate dataRealizacao;
    @Column(name = "PONTOS")
    private Integer pontos;
    @Transient
    private String kpi;

    public static List<Pontuacao> entradaKpiToPontuario(EntradaKpi entradaKpi) {
        return entradaKpi.getKpiPontuacao().stream()
                .map(pontuacao ->
                        Pontuacao.builder()
                                .dataRealizacao(entradaKpi.getDataReferencia())
                                .kpi(pontuacao.getKpi())
                                .pontos(pontuacao.getValor() != null ? pontuacao.getValor() : 0)
                                .build())
                .collect(Collectors.toList());
    }

}
