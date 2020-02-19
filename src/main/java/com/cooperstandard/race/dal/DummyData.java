package com.cooperstandard.race.dal;

import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.cooperstandard.race.config.SpringContext.getContext;

public class DummyData {

    public DummyData() {
        startDammyData();
    }

    private void startDammyData() {
        dropAllObjects();
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
