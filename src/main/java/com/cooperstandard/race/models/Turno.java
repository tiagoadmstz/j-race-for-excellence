package com.cooperstandard.race.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MOV_TURNO")
public class Turno implements Serializable {

    private static final long serialVersionUID = -1415446929429882753L;
    @Id
    @Column(name = "TURNO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NOME", length = 100)
    private String nome;
    @Column(name = "ORDEM")
    private Integer ordem;
    @Column(name = "CARRO", length = 100)
    private String carro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "turno")
    private List<Pontuacao> pontuacao;
    @Transient
    private Long totalPontuacao;

    public Long getTotalPontuacao() {
        if (totalPontuacao == 0)
            totalPontuacao = pontuacao.stream().map(Pontuacao::getPontos).reduce(Integer::sum).orElse(0).longValue();
        return totalPontuacao;
    }

}
