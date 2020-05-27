package com.cooperstandard.race.dal;

import com.cooperstandard.race.dal.repositories.CorridaRepository;
import com.cooperstandard.race.models.Corrida;
import com.cooperstandard.race.models.Kpi;
import com.cooperstandard.race.models.MetodoPontuacao;
import com.cooperstandard.race.models.Turno;
import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
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
        CorridaRepository corridaRepository = getContext().getBean(CorridaRepository.class);
        if (corridaRepository.findAll().isEmpty()) {
            List<Kpi> kpis = Arrays.asList(
                    Kpi.builder().ativo(true).nome("OEE").tipoEntrada("Porcentagem").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">=").pontuacao(10L).valor(93F).build(),
                            MetodoPontuacao.builder().comparacao(">=").pontuacao(5L).valor(91F).build(),
                            MetodoPontuacao.builder().comparacao("<").pontuacao(0L).valor(91F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("renault.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("williams.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("mclaren.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("SCRAP").tipoEntrada("Porcentagem").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(15L).valor(0.5F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(10L).valor(1F).build(),
                            MetodoPontuacao.builder().comparacao(">").pontuacao(0L).valor(1F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("toro-rosso.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("sauber.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("ferrari6.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("DOWNTIME").tipoEntrada("Unidade").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao(">").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("renault5.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("haas.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("force-india.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("SETUP").tipoEntrada("Minutos").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(10L).valor(3F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(5L).valor(10F).build(),
                            MetodoPontuacao.builder().comparacao(">").pontuacao(0L).valor(10F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("red-bull8.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("williams1.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("mclaren3.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("BTS").tipoEntrada("Porcentagem").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">=").pontuacao(10L).valor(100F).build(),
                            MetodoPontuacao.builder().comparacao(">=").pontuacao(5L).valor(90F).build(),
                            MetodoPontuacao.builder().comparacao("<").pontuacao(0L).valor(90F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("toro-rosso4.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("sauber1.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("force-india4.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("SEGURANÇA").tipoEntrada("Sim e Não").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(20L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao(">").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("red-bull.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("mercedes.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("ferrari.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("ABSENTEÍSMO").tipoEntrada("Unidade").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao(">").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("renault1.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("williams2.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("mclaren1.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("CP e CPK").tipoEntrada("Sim e Não").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("red-bull3.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("haas1.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("force-india5.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("BTO").tipoEntrada("Unidade").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("toro-rosso8.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("sauber2.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("ferrari3.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("QUALIDADE VARGINHA").tipoEntrada("Unidade").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(20L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao(">").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("renault7.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("mercedes1.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("mclaren8.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("QUALIDADE ATIBAIA").tipoEntrada("Unidade").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(20L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao(">").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("red-bull4.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("williams3.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("force-india8.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM GRANULADOR").tipoEntrada("Sim e Não").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("toro-rosso7.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("haas4.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("ferrari8.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM BATCH OFF").tipoEntrada("Sim e Não").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("renault4.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("sauber3.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("mclaren7.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM STRIP MILL").tipoEntrada("Sim e Não").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("red-bull6.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("mercedes4.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("force-india91.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM BLEND 1").tipoEntrada("Sim e Não").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("toro-rosso1.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("williams4.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("ferrari4.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM BLEND 2").tipoEntrada("Sim e Não").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("renault6.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("sauber4.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("mclaren4.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM DROP").tipoEntrada("Sim e Não").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("red-bull9.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("haas6.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("force-india3.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM MISTURADOR").tipoEntrada("Sim e Não").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("toro-rosso6.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("mercedes5.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("ferrari9.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM PESAGEM").tipoEntrada("Sim e Não").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("renault3.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("sauber7.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("mclaren2.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM CHRONOS").tipoEntrada("Sim e Não").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("red-bull7.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("sauber6.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("force-india2.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM NORMEC").tipoEntrada("Sim e Não").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("toro-rosso2.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("haas9.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("ferrari5.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM STRAINER").tipoEntrada("Sim e Não").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("renault2.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("mercedes8.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("mclaren5.png").build()
                    )).build(),
                    Kpi.builder().ativo(true).nome("TPM LABORATÓRIO").tipoEntrada("Sim e Não").metodoPontuacao(Arrays.asList(
                            MetodoPontuacao.builder().comparacao(">").pontuacao(10L).valor(0F).build(),
                            MetodoPontuacao.builder().comparacao("<=").pontuacao(0L).valor(0F).build()
                    )).turnos(Arrays.asList(
                            Turno.builder().nome("A").ordem(1).carro("red-bull1.png").build(),
                            Turno.builder().nome("B").ordem(2).carro("force-india9.png").build(),
                            Turno.builder().nome("C").ordem(3).carro("haas8.png").build()
                    )).build()
            );

            corridaRepository.save(Corrida.builder()
                    .dataValidade(LocalDate.of(2021, 1, 1))
                    .meta(480L)
                    .kpis(kpis)
                    .build());
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
