package com.cooperstandard.race.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CAD_META")
public class Meta implements Serializable {

    @Id
    @Column(name = "META")
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
