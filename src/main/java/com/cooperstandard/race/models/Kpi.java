package com.cooperstandard.race.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CAD_KPI")
public class Kpi {

    @Id
    private Long id;
    @ManyToMany
    private List<Meta> meta;
    @ManyToMany
    private List<Turno> turnos;

}
