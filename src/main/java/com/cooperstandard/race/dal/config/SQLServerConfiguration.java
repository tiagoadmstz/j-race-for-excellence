package com.cooperstandard.race.dal.config;

import com.cooperstandard.race.dal.interfaces.DatabaseConfiguration;

import java.util.Properties;

public class SQLServerConfiguration implements DatabaseConfiguration {

    @Override
    public String getDriver() {
        return "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    }

    @Override
    public String getUrl() {
        return "jdbc:sqlserver://VARWSQL1;databaseName=DADOSPROD";
    }

    @Override
    public String getUsername() {
        return "PROD";
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public Properties getProperties() {
        Properties properties = new Properties();
        properties.put("eclipselink.target-database", "SQLServer");
        properties.put("eclipselink.logging.level", "OFF");
        properties.put("eclipselink.ddl-generation", "create-or-extend-tables");
        properties.put("eclipselink.persistence-context.flush-mode", "commit");
        properties.put("eclipselink.persistence-context.close-on-commit", "true");
        properties.put("eclipselink.cache.shared.default", "false");
        properties.put("eclipselink.flush", "true");
        properties.put("eclipselink.connection-pool.default.initial", "1");
        properties.put("eclipselink.connection-pool.node2.min", "800");
        properties.put("eclipselink.connection-pool.node2.max", "800");
        properties.put("eclipselink.jdbc.timeout", "5000");
        properties.put("eclipselink.weaving", "STATIC");
        properties.put("eclipselink.weaving.eager", "FALSE");
        properties.put("eclipselink.id-validation", "NEGATIVE");
        return properties;
    }

}
