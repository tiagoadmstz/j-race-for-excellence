package com.cooperstandard.race.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MOV_TURNO")
public class Turno {

    @Id
    private Long id;
    @ManyToMany
    private List<Pontuacao> pontuacao;
    @Column(name = "TOTAL_PONTUACAO")
    private Long totalPontuacao;

}
