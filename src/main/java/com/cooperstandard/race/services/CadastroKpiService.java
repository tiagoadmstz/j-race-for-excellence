package com.cooperstandard.race.services;

import com.cooperstandard.race.dal.repositories.KpiRepository;
import com.cooperstandard.race.frames.views.CadastroKpi;
import com.cooperstandard.race.models.Kpi;
import com.cooperstandard.race.models.Turno;
import com.cooperstandard.race.util.ExecutionUtil;
import com.cooperstandard.race.util.ImageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.cooperstandard.race.util.Utilidades.selectFiles;

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

    public void selectCar(CadastroKpi cadastroKpi) {
        Turno turno = cadastroKpi.getTbTurnosModel().getObject(cadastroKpi.getTbTurnos().getSelectedRow());
        if (turno == null) {
            JOptionPane.showMessageDialog(cadastroKpi, "É necessário selecionar o turno!", "Nenhum registro selecionado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String car = selectFiles("Selecionar", "config/images/cars", "png", "jpg");
            cadastroKpi.getLbCarro().setIcon(ImageUtil.getImageIconFromUserPath("config/images/cars/".concat(car)));
            turno.setCarro(car);
        }
    }

    public MouseAdapter selectedCarListener(CadastroKpi cadastroKpi) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                Turno turno = cadastroKpi.getTbTurnosModel().getObject(cadastroKpi.getTbTurnos().getSelectedRow());
                if (turno != null) {
                    if (turno.getCarro() != null)
                        cadastroKpi.getLbCarro().setIcon(ImageUtil.getImageIconFromUserPath("config/images/cars/".concat(turno.getCarro())));
                    else cadastroKpi.getLbCarro().setIcon(null);
                }
            }
        };
    }

}
