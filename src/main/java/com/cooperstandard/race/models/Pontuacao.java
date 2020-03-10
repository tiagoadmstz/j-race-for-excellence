package com.cooperstandard.race.models;

import com.cooperstandard.race.converters.LocalDateConverter;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MOV_PONTUACAO_TURNO")
public class Pontuacao implements Serializable {

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

}
