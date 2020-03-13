package com.cooperstandard.race.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntradaKpi implements Serializable {

    private static final long serialVersionUID = -4829347369192501920L;
    private LocalDate dataReferencia;
    private String turno;
    private List<EntradaKpiPontuacao> kpiPontuacao;

}
