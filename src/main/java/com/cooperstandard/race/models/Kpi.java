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
@Table(name = "CAD_KPI")
public class Kpi implements Serializable {

    private static final long serialVersionUID = -8639352766092615216L;
    @Id
    @Column(name = "KPI")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NOME", length = 100)
    private String nome;
    @Column(name = "TIPO_ENTRADA", length = 100)
    private String tipoEntrada;
    @Column(name = "ATIVO", columnDefinition = "bit")
    private Boolean ativo;
    @Column(name = "META")
    private Long meta;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<MetodoPontuacao> metodoPontuacao;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Turno> turnos;

}
