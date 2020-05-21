package com.cooperstandard.race.dal.repositories;

import com.cooperstandard.race.models.Pontuacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PontuacaoRepository extends JpaRepository<Pontuacao, Long> {

    List<Pontuacao> findByTurnoId(Long turnoId);

    Optional<Long> findIdByDataRealizacaoAndTurnoId(LocalDate dataRealizacao, Long turnoId);

}
