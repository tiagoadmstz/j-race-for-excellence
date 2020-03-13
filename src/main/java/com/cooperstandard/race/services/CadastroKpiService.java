package com.cooperstandard.race.services;

import com.cooperstandard.race.dal.repositories.KpiRepository;
import com.cooperstandard.race.models.Kpi;
import com.cooperstandard.race.util.ExecutionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CadastroKpiService {

    private final KpiRepository cadastroKpiRepository;

    public Kpi saveOrUpdate(Kpi kpi) {
        return ExecutionUtil.trySelfExecution(() -> {
            Kpi save = cadastroKpiRepository.save(kpi);
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");
            return save;
        }, kpi);
    }

    public boolean delete(Long id) {
        return ExecutionUtil.trySelfExecution(() -> {
            cadastroKpiRepository.deleteById(id);
            return true;
        }, false);
    }

}
