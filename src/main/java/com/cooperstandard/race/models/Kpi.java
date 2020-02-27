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

    @Id
    @Column(name = "KPI")
    private Long id;
    @Column(name = "NOME", length = 100)
    private String nome;
    @Column(name = "TIPO_ENTRADA", length = 100)
    private String tipoEntrada;
    @Column(name = "ATIVO", columnDefinition = "boolean")
    private Boolean ativo;
    @Column(name = "CARRO", length = 100)
    private String carro;
    @ManyToMany
    private List<Meta> meta;
    @ManyToMany
    private List<Turno> turnos;

}
