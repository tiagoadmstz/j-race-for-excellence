package com.cooperstandard.race;

import com.cooperstandard.race.config.SpringContext;
import com.cooperstandard.race.dal.DummyData;
import com.cooperstandard.race.dal.repositories.KpiRepository;
import com.cooperstandard.race.models.Kpi;
import com.cooperstandard.race.models.MetodoPontuacao;
import org.junit.Test;

public class RaceForExcellenceApplicationTest {

    @Test
    public void comparacaoTest() {
        new DummyData();
        KpiRepository kpiRepository = SpringContext.getContext().getBean(KpiRepository.class);
        Kpi kpi = kpiRepository.findByNome("OEE");
        for(MetodoPontuacao metodoPontuacao : kpi.getMetodoPontuacao()){
            Integer pontuacao = metodoPontuacao.compararValores(91F);
            System.out.println(pontuacao);
        }
        Long pontuacao = kpi.getMetodoPontuacao().stream()
                .filter(mp -> mp.compararValores(91F) > 0)
                .map(MetodoPontuacao::getPontuacao)
                .findFirst().orElse(0L);
        System.out.println(pontuacao);
    }

}
