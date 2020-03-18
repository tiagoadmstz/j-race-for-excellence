package com.cooperstandard.race.dal;

import com.cooperstandard.race.dal.repositories.KpiRepository;
import com.cooperstandard.race.models.Kpi;
import com.cooperstandard.race.models.MetodoPontuacao;
import com.cooperstandard.race.models.Turno;
import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static com.cooperstandard.race.config.SpringContext.getContext;

public class DummyData {

    public DummyData() {
        startDammyData();
    }

    private void startDammyData() {
        //dropAllObjects();
        createCadastroKpi();
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
        if (kpiRepository.findAll().isEmpty()) {
            List<Kpi> kpis = Arrays.asList(
                    Kpi.builder().ativo(true).nome("OEE").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">=").valor(95F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">=").valor(91F).pontuacao(5L).build(),
                            MetodoPontuacao.builder().comparacao("<").valor(91F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").totalPontuacao(100L).carro("mercedes.png").build(),
                            Turno.builder().nome("B").totalPontuacao(80L).carro("mclaren.png").build(),
                            Turno.builder().nome("C").totalPontuacao(120L).carro("red-bull.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("SCRAP").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(5F).pontuacao(15L).build(),
                            MetodoPontuacao.builder().comparacao("<=").valor(1F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(1F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").totalPontuacao(80L).carro("sauber.png").build(),
                            Turno.builder().nome("B").totalPontuacao(120L).carro("force-india.png").build(),
                            Turno.builder().nome("C").totalPontuacao(200L).carro("renault.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("DOWNTIME").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").totalPontuacao(200L).carro("williams.png").build(),
                            Turno.builder().nome("B").totalPontuacao(150L).carro("toro-rosso.png").build(),
                            Turno.builder().nome("C").totalPontuacao(130L).carro("haas.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("SETUP").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(3F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao("<=").valor(10F).pontuacao(5L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(10F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").totalPontuacao(100L).carro("mercedes.png").build(),
                            Turno.builder().nome("B").totalPontuacao(80L).carro("mclaren.png").build(),
                            Turno.builder().nome("C").totalPontuacao(120L).carro("red-bull.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("BPS").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">=").valor(100F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">=").valor(90F).pontuacao(5L).build(),
                            MetodoPontuacao.builder().comparacao("<").valor(90F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").totalPontuacao(100L).carro("mercedes.png").build(),
                            Turno.builder().nome("B").totalPontuacao(80L).carro("mclaren.png").build(),
                            Turno.builder().nome("C").totalPontuacao(120L).carro("red-bull.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("SEGURANÇA").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(20L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").totalPontuacao(80L).carro("sauber.png").build(),
                            Turno.builder().nome("B").totalPontuacao(120L).carro("force-india.png").build(),
                            Turno.builder().nome("C").totalPontuacao(200L).carro("renault.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("ABSENTEÍSMO").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").totalPontuacao(200L).carro("williams.png").build(),
                            Turno.builder().nome("B").totalPontuacao(150L).carro("toro-rosso.png").build(),
                            Turno.builder().nome("C").totalPontuacao(130L).carro("haas.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("CP e CPK").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").totalPontuacao(100L).carro("mercedes.png").build(),
                            Turno.builder().nome("B").totalPontuacao(80L).carro("mclaren.png").build(),
                            Turno.builder().nome("C").totalPontuacao(120L).carro("red-bull.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("BTOP").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").totalPontuacao(100L).carro("mercedes.png").build(),
                            Turno.builder().nome("B").totalPontuacao(80L).carro("mclaren.png").build(),
                            Turno.builder().nome("C").totalPontuacao(120L).carro("red-bull.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("QUALIDADE VARGINHA").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(20L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").totalPontuacao(80L).carro("sauber.png").build(),
                            Turno.builder().nome("B").totalPontuacao(120L).carro("force-india.png").build(),
                            Turno.builder().nome("C").totalPontuacao(200L).carro("renault.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("QUALIDADE ATIBAIA").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(20L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").totalPontuacao(200L).carro("williams.png").build(),
                            Turno.builder().nome("B").totalPontuacao(150L).carro("toro-rosso.png").build(),
                            Turno.builder().nome("C").totalPontuacao(130L).carro("haas.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM GRANULADOR").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").totalPontuacao(100L).carro("mercedes.png").build(),
                            Turno.builder().nome("B").totalPontuacao(80L).carro("mclaren.png").build(),
                            Turno.builder().nome("C").totalPontuacao(120L).carro("red-bull.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM BATCH OFF").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").totalPontuacao(100L).carro("mercedes.png").build(),
                            Turno.builder().nome("B").totalPontuacao(80L).carro("mclaren.png").build(),
                            Turno.builder().nome("C").totalPontuacao(120L).carro("red-bull.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM STRIP MILL").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").totalPontuacao(80L).carro("sauber.png").build(),
                            Turno.builder().nome("B").totalPontuacao(120L).carro("force-india.png").build(),
                            Turno.builder().nome("C").totalPontuacao(200L).carro("renault.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM BLEND 1").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").totalPontuacao(200L).carro("williams.png").build(),
                            Turno.builder().nome("B").totalPontuacao(150L).carro("toro-rosso.png").build(),
                            Turno.builder().nome("C").totalPontuacao(130L).carro("haas.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM BLEND 2").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").totalPontuacao(100L).carro("mercedes.png").build(),
                            Turno.builder().nome("B").totalPontuacao(80L).carro("mclaren.png").build(),
                            Turno.builder().nome("C").totalPontuacao(120L).carro("red-bull.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM DROP").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").totalPontuacao(100L).carro("mercedes.png").build(),
                            Turno.builder().nome("B").totalPontuacao(80L).carro("mclaren.png").build(),
                            Turno.builder().nome("C").totalPontuacao(120L).carro("red-bull.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM MISTURADOR").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").totalPontuacao(80L).carro("sauber.png").build(),
                            Turno.builder().nome("B").totalPontuacao(120L).carro("force-india.png").build(),
                            Turno.builder().nome("C").totalPontuacao(200L).carro("renault.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM PESAGEM").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").totalPontuacao(200L).carro("williams.png").build(),
                            Turno.builder().nome("B").totalPontuacao(150L).carro("toro-rosso.png").build(),
                            Turno.builder().nome("C").totalPontuacao(130L).carro("haas.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM CHRONOS").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").totalPontuacao(100L).carro("mercedes.png").build(),
                            Turno.builder().nome("B").totalPontuacao(80L).carro("mclaren.png").build(),
                            Turno.builder().nome("C").totalPontuacao(120L).carro("red-bull.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM NORMEC").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").totalPontuacao(100L).carro("mercedes.png").build(),
                            Turno.builder().nome("B").totalPontuacao(80L).carro("mclaren.png").build(),
                            Turno.builder().nome("C").totalPontuacao(120L).carro("red-bull.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM STRAINER").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").totalPontuacao(80L).carro("sauber.png").build(),
                            Turno.builder().nome("B").totalPontuacao(120L).carro("force-india.png").build(),
                            Turno.builder().nome("C").totalPontuacao(200L).carro("renault.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM RHEÔMETRIA").meta(480L).metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").valor(0F).pontuacao(10L).build(),
                            MetodoPontuacao.builder().comparacao(">").valor(0F).pontuacao(0L).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").totalPontuacao(200L).carro("williams.png").build(),
                            Turno.builder().nome("B").totalPontuacao(150L).carro("toro-rosso.png").build(),
                            Turno.builder().nome("C").totalPontuacao(130L).carro("haas.png").build()
                    )).build()
            );
            kpiRepository.saveAll(kpis);
        }
        kpiRepository.findAll().forEach(System.out::println);
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
