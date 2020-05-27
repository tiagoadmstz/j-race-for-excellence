package com.cooperstandard.race.dal.repositories;

import com.cooperstandard.race.models.EntradaKpiPontuacao;
import com.cooperstandard.race.models.Kpi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface KpiRepository extends JpaRepository<Kpi, Long> {

    List<Kpi> findByTurnosNome(String turno);

    Kpi findByNome(String nome);

    Optional<List<Kpi>> findByTurnosNomeAndTurnosPontuacaoDataRealizacao(String turno, LocalDate date);

}
