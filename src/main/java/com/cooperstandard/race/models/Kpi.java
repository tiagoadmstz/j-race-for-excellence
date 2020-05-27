package com.cooperstandard.race.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@ToString
@EqualsAndHashCode
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
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<MetodoPontuacao> metodoPontuacao = new ArrayList<>();
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Turno> turnos = new ArrayList<>();

    //public List<Pontuacao> getPontuacaoByTurnoName(String turno) {
    //    return turnos.stream().filter(t -> turno.equals(t.getNome())).map(Turno::getPontuacao).findFirst().orElse(new ArrayList());
    //}

    //public Turno getTurnoByNome(String turno) {
    //    return turnos.stream().filter(t -> turno.equals(t.getNome())).findFirst().orElse(null);
    //}

}
