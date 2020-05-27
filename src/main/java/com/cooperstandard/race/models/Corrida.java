package com.cooperstandard.race.models;

import com.cooperstandard.race.converters.LocalDateConverter;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CAD_CORRIDA")
public class Corrida implements Serializable {

    private static final long serialVersionUID = 7283727473573432448L;
    @Id
    @Column(name = "CORRIDA")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Builder.Default
    @Convert(converter = LocalDateConverter.class)
    @Column(name = "DATA_ABERTURA", columnDefinition = "date")
    private LocalDate dataAbertura = LocalDate.now();
    @Convert(converter = LocalDateConverter.class)
    @Column(name = "DATA_VALIDADE", columnDefinition = "date")
    private LocalDate dataValidade;
    @Column(name = "META")
    private Long meta;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Kpi> kpis = new ArrayList();

}
