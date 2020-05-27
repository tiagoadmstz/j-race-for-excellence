package com.cooperstandard.race.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@ToString(exclude = "totalPontuacao")
@EqualsAndHashCode
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
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Pontuacao> pontuacao = new ArrayList();
    @Transient
    private Long totalPontuacao = 0L;

    public Long getTotalPontuacao() {
        if (totalPontuacao == 0L) if (!pontuacao.isEmpty())
            totalPontuacao = pontuacao.stream().map(Pontuacao::getPontos).reduce(Integer::sum).orElse(0).longValue();
        return totalPontuacao;
    }

}
