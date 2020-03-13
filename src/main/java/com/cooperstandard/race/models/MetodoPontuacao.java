package com.cooperstandard.race.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CAD_METODO_PONTUACAO")
public class MetodoPontuacao implements Serializable {

    private static final long serialVersionUID = -8828799741223222509L;
    @Id
    @Column(name = "METODO_PONTUACAO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "VALOR")
    private Long valor;
    @Column(name = "COMPARACAO", length = 10)
    private String comparacao;
    @Column(name = "PONTUACAO")
    private Long pontuacao;
    @Column(name = "COR")
    private Integer cor;

}
