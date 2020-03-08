package com.cooperstandard.race.services;

import com.cooperstandard.race.dal.repositories.KpiRepository;
import com.cooperstandard.race.models.Kpi;
import com.cooperstandard.race.util.ExecutionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CadastroKpiService {

    private final KpiRepository cadastroKpiRepository;

    public Kpi saveOrUpdate(Kpi kpi) {
        return ExecutionUtil.trySelfExecution(() -> cadastroKpiRepository.save(kpi), kpi);
    }

    public boolean delete(Long id) {
        return ExecutionUtil.trySelfExecution(() -> {
            cadastroKpiRepository.deleteById(id);
            return true;
        }, false);
    }

}
