package com.cooperstandard.race.dal.repositories;

import com.cooperstandard.race.models.Pontuacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontuacaoRepository extends JpaRepository<Pontuacao, Long> {

}
