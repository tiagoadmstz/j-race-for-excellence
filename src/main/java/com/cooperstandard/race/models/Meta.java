package com.cooperstandard.race.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CAD_META")
public class Meta {

    @Id
    private Long id;
    @Column(name = "META")
    private BigDecimal meta;
    @Column(name = "META_TYPE")
    private String meta_type;
    @Column(name = "PONTUACAO")
    private BigDecimal pontuacao;

}
