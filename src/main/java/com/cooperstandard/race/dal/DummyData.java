package com.cooperstandard.race.dal;

import com.cooperstandard.race.dal.repositories.KpiRepository;
import com.cooperstandard.race.dal.repositories.PontuacaoRepository;
import com.cooperstandard.race.models.Kpi;
import com.cooperstandard.race.models.MetodoPontuacao;
import com.cooperstandard.race.models.Pontuacao;
import com.cooperstandard.race.models.Turno;
import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.cooperstandard.race.config.SpringContext.getContext;

public class DummyData {

    public DummyData() {
        startDammyData();
    }

    private void startDammyData() {
        //dropAllObjects();
        createCadastroKpiV2();
    }

    @SneakyThrows
    private void dropAllObjects() {
        Connection connection = getConnection();
        preparedStatementAndExecute(connection, "DROP ALL OBJECTS");
        commitAndClose(connection);
    }

    @SneakyThrows
    private void truncatedTable() {
        Connection connection = getConnection();
        preparedStatementAndExecute(connection, "TRUNCATE TABLE [*]");
        commitAndClose(connection);
    }

    private void createCadastroKpi() {
        KpiRepository kpiRepository = getContext().getBean(KpiRepository.class);
        PontuacaoRepository pontuacaoRepository = getContext().getBean(PontuacaoRepository.class);
        if (kpiRepository.findAll().isEmpty()) {
            List<Kpi> kpis = Arrays.asList(
                    Kpi.builder().ativo(true).nome("OEE").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">=").valor(95F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">=").valor(91F).pontuacao(5L).build(),
                            MetodoPontuacao.builder().comparacao("<").valor(91F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(100).build())).carro("mercedes.png").build(),
                            Turno.builder().nome("B").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(80).build())).carro("mclaren.png").build(),
                            Turno.builder().nome("C").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(120).build())).carro("red-bull.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("SCRAP").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(5F).pontuacao(15L).build(),
                            MetodoPontuacao.builder().comparacao("<=").valor(1F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(1F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(80).build())).carro("sauber.png").build(),
                            Turno.builder().nome("B").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(120).build())).carro("force-india.png").build(),
                            Turno.builder().nome("C").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(200).build())).carro("renault.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("DOWNTIME").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(200).build())).carro("williams.png").build(),
                            Turno.builder().nome("B").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(150).build())).carro("toro-rosso.png").build(),
                            Turno.builder().nome("C").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(130).build())).carro("haas.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("SETUP").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(3F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao("<=").valor(10F).pontuacao(5L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(10F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(100).build())).carro("mercedes.png").build(),
                            Turno.builder().nome("B").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(80).build())).carro("mclaren.png").build(),
                            Turno.builder().nome("C").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(120).build())).carro("red-bull.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("BPS").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">=").valor(100F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">=").valor(90F).pontuacao(5L).build(),
                            MetodoPontuacao.builder().comparacao("<").valor(90F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(100).build())).carro("mercedes.png").build(),
                            Turno.builder().nome("B").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(80).build())).carro("mclaren.png").build(),
                            Turno.builder().nome("C").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(120).build())).carro("red-bull.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("SEGURANÇA").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(20L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(80).build())).carro("sauber.png").build(),
                            Turno.builder().nome("B").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(120).build())).carro("force-india.png").build(),
                            Turno.builder().nome("C").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(200).build())).carro("renault.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("ABSENTEÍSMO").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(200).build())).carro("williams.png").build(),
                            Turno.builder().nome("B").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(150).build())).carro("toro-rosso.png").build(),
                            Turno.builder().nome("C").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(130).build())).carro("haas.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("CP e CPK").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(100).build())).carro("mercedes.png").build(),
                            Turno.builder().nome("B").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(80).build())).carro("mclaren.png").build(),
                            Turno.builder().nome("C").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(120).build())).carro("red-bull.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("BTOP").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(100).build())).carro("mercedes.png").build(),
                            Turno.builder().nome("B").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(80).build())).carro("mclaren.png").build(),
                            Turno.builder().nome("C").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(120).build())).carro("red-bull.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("QUALIDADE VARGINHA").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(20L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(80).build())).carro("sauber.png").build(),
                            Turno.builder().nome("B").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(120).build())).carro("force-india.png").build(),
                            Turno.builder().nome("C").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(200).build())).carro("renault.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("QUALIDADE ATIBAIA").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(20L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(200).build())).carro("williams.png").build(),
                            Turno.builder().nome("B").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(150).build())).carro("toro-rosso.png").build(),
                            Turno.builder().nome("C").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(130).build())).carro("haas.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM GRANULADOR").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(100).build())).carro("mercedes.png").build(),
                            Turno.builder().nome("B").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(80).build())).carro("mclaren.png").build(),
                            Turno.builder().nome("C").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(120).build())).carro("red-bull.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM BATCH OFF").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(100).build())).carro("mercedes.png").build(),
                            Turno.builder().nome("B").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(80).build())).carro("mclaren.png").build(),
                            Turno.builder().nome("C").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(120).build())).carro("red-bull.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM STRIP MILL").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(80).build())).carro("sauber.png").build(),
                            Turno.builder().nome("B").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(120).build())).carro("force-india.png").build(),
                            Turno.builder().nome("C").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(200).build())).carro("renault.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM BLEND 1").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(200).build())).carro("williams.png").build(),
                            Turno.builder().nome("B").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(150).build())).carro("toro-rosso.png").build(),
                            Turno.builder().nome("C").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(130).build())).carro("haas.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM BLEND 2").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(100).build())).carro("mercedes.png").build(),
                            Turno.builder().nome("B").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(80).build())).carro("mclaren.png").build(),
                            Turno.builder().nome("C").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(120).build())).carro("red-bull.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM DROP").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(100).build())).carro("mercedes.png").build(),
                            Turno.builder().nome("B").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(80).build())).carro("mclaren.png").build(),
                            Turno.builder().nome("C").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(120).build())).carro("red-bull.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM MISTURADOR").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(80).build())).carro("sauber.png").build(),
                            Turno.builder().nome("B").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(120).build())).carro("force-india.png").build(),
                            Turno.builder().nome("C").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(200).build())).carro("renault.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM PESAGEM").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(200).build())).carro("williams.png").build(),
                            Turno.builder().nome("B").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(150).build())).carro("toro-rosso.png").build(),
                            Turno.builder().nome("C").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(130).build())).carro("haas.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM CHRONOS").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(100).build())).carro("mercedes.png").build(),
                            Turno.builder().nome("B").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(80).build())).carro("mclaren.png").build(),
                            Turno.builder().nome("C").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(120).build())).carro("red-bull.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM NORMEC").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(100).build())).carro("mercedes.png").build(),
                            Turno.builder().nome("B").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(80).build())).carro("mclaren.png").build(),
                            Turno.builder().nome("C").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(120).build())).carro("red-bull.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM STRAINER").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(80).build())).carro("sauber.png").build(),
                            Turno.builder().nome("B").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(120).build())).carro("force-india.png").build(),
                            Turno.builder().nome("C").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(200).build())).carro("renault.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM RHEÔMETRIA").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(200).build())).carro("williams.png").build(),
                            Turno.builder().nome("B").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(150).build())).carro("toro-rosso.png").build(),
                            Turno.builder().nome("C").pontuacao(Arrays.asList(Pontuacao.builder().dataRealizacao(LocalDate.now()).pontos(130).build())).carro("haas.png").build()
                    )).build()
            );
            kpiRepository.saveAll(kpis);
            kpis.stream().forEach(kpi -> {
                kpi.getTurnos().stream().map(turno ->
                        pontuacaoRepository.saveAll(turno.getPontuacao().stream().map(pontuacao -> {
                            pontuacao.setTurnoId(turno.getId());
                            return pontuacao;
                        }).collect(Collectors.toList()))
                ).collect(Collectors.toList());
            });
        }
        //kpiRepository.findAll().forEach(System.out::println);
    }

    private void createCadastroKpiV2() {
        KpiRepository kpiRepository = getContext().getBean(KpiRepository.class);
        if (kpiRepository.findAll().isEmpty()) {
            List<Kpi> kpis = Arrays.asList(
                    Kpi.builder().ativo(true).nome("OEE").meta(480L).tipoEntrada("Porcentagem").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">=").pontuacao(10L).valor(93F).build(),
                            MetodoPontuacao.builder().comparacao(">=").pontuacao(5L).valor(91F).build(),
                            MetodoPontuacao.builder().comparacao("<").pontuacao(0L).valor(91F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("renault.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("williams.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("mclaren.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("SCRAP").meta(480L).tipoEntrada("Porcentagem").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(15L).valor(0.5F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(10L).valor(1F).build(),
                            MetodoPontuacao.builder().comparacao(">").pontuacao(0L).valor(1F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("toro-rosso.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("sauber.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("ferrari6.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("DOWNTIME").meta(480L).tipoEntrada("Unidade").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao(">").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("renault5.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("haas.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("force-india.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("SETUP").meta(480L).tipoEntrada("Minutos").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(10L).valor(3F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(5L).valor(10F).build(),
                            MetodoPontuacao.builder().comparacao(">").pontuacao(0L).valor(10F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("red-bull8.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("williams1.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("mclaren3.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("BTS").meta(480L).tipoEntrada("Porcentagem").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">=").pontuacao(10L).valor(100F).build(),
                            MetodoPontuacao.builder().comparacao(">=").pontuacao(5L).valor(90F).build(),
                            MetodoPontuacao.builder().comparacao("<").pontuacao(0L).valor(90F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("toro-rosso4.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("sauber1.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("force-india4.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("SEGURANÇA").meta(480L).tipoEntrada("Sim e Não").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(20L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao(">").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("red-bull.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("mercedes.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("ferrari.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("ABSENTEÍSMO").meta(480L).tipoEntrada("Unidade").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao(">").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("renault1.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("williams2.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("mclaren1.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("CP e CPK").meta(480L).tipoEntrada("Sim e Não").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("red-bull3.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("haas1.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("force-india5.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("BTO").meta(480L).tipoEntrada("Unidade").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("toro-rosso8.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("sauber2.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("ferrari3.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("QUALIDADE VARGINHA").meta(480L).tipoEntrada("Unidade").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(20L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao(">").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("renault7.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("mercedes1.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("mclaren8.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("QUALIDADE ATIBAIA").meta(480L).tipoEntrada("Unidade").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(20L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao(">").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("red-bull4.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("williams3.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("force-india8.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM GRANULADOR").meta(480L).tipoEntrada("Sim e Não").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("toro-rosso7.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("haas4.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("ferrari8.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM BATCH OFF").meta(480L).tipoEntrada("Sim e Não").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("renault4.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("sauber3.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("mclaren7.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM STRIP MILL").meta(480L).tipoEntrada("Sim e Não").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("red-bull6.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("mercedes4.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("force-india91.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM BLEND 1").meta(480L).tipoEntrada("Sim e Não").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("toro-rosso1.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("williams4.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("ferrari4.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM BLEND 2").meta(480L).tipoEntrada("Sim e Não").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("renault6.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("sauber4.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("mclaren4.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM DROP").meta(480L).tipoEntrada("Sim e Não").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("red-bull9.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("haas6.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("force-india3.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM MISTURADOR").meta(480L).tipoEntrada("Sim e Não").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("toro-rosso6.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("mercedes5.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("ferrari9.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM PESAGEM").meta(480L).tipoEntrada("Sim e Não").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("renault3.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("sauber7.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("mclaren2.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM CHRONOS").meta(480L).tipoEntrada("Sim e Não").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("red-bull7.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("sauber6.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("force-india2.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM NORMEC").meta(480L).tipoEntrada("Sim e Não").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("toro-rosso2.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("haas9.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("ferrari5.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM STRAINER").meta(480L).tipoEntrada("Sim e Não").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("renault2.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("mercedes8.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("mclaren5.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM LABORATÓRIO").meta(480L).tipoEntrada("Sim e Não").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("red-bull1.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("force-india9.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("haas8.png").build()
                    )).build()
            );
            kpiRepository.saveAll(kpis);
        }
    }

    private Connection getConnection() throws SQLException {
        return getContext().getBean(DataSource.class).getConnection();
    }

    private void preparedStatementAndExecute(Connection connection, String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();
    }

    private void commitAndClose(Connection connection) throws SQLException {
        connection.commit();
        connection.close();
    }

}
