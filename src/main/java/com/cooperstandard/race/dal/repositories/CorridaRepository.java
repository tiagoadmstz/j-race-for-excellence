package com.cooperstandard.race.dal.repositories;

import com.cooperstandard.race.models.Corrida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface CorridaRepository extends JpaRepository<Corrida, Long> {

    @Query(value = "FROM Corrida AS crd WHERE crd.dataAbertura >= ?1 AND crd.dataValidade < ?1")
    Optional<Corrida> findByDataAberturaAndDataValidade(LocalDate date);

}
