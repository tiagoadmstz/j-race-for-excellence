package com.cooperstandard.race.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MOV_TURNO")
public class Turno implements Serializable {

    @Id
    @Column(name = "TURNO")
    private Long id;
    @Column(name = "NOME", length = 100)
    private String nome;
    @Column(name = "ORDEM")
    private Integer ordem;
    @Column(name = "CARRO", length = 100)
    private String carro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "turno")
    private List<Pontuacao> pontuacao;
    @Column(name = "TOTAL_PONTUACAO")
    private Long totalPontuacao;

}
