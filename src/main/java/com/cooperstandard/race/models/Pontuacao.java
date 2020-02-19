package com.cooperstandard.race.models;

import com.cooperstandard.race.converters.LocalDateConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MOV_PONTUACAO_TURNO")
public class Pontuacao {

    @Id
    private Long id;
    @Convert(converter = LocalDateConverter.class)
    @Column(name = "DATA_REALIZACAO")
    private LocalDate dataRealizacao;
    @Column(name = "PONTOS")
    private BigDecimal pontos;

}
