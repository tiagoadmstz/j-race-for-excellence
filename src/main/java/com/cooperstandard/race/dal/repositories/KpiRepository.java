package com.cooperstandard.race.dal.repositories;

import com.cooperstandard.race.models.Kpi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KpiRepository extends JpaRepository<Kpi, Long> {

    @Query("SELECT k.nome FROM Kpi AS k")
    List<String> findNomeAll();

    Kpi findByNome(String nome);

}
