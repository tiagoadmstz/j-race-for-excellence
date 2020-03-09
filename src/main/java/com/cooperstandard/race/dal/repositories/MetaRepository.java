package com.cooperstandard.race.dal.repositories;

import com.cooperstandard.race.models.MetodoPontuacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaRepository extends JpaRepository<MetodoPontuacao, Long> {
}
