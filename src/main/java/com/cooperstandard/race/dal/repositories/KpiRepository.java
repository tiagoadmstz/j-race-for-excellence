package com.cooperstandard.race.dal.repositories;

import com.cooperstandard.race.models.Kpi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KpiRepository extends JpaRepository<Kpi, Long> {
}
