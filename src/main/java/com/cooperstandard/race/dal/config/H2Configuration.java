package com.cooperstandard.race.dal.config;

import com.cooperstandard.race.dal.interfaces.DatabaseConfiguration;

import java.util.Properties;

public class H2Configuration implements DatabaseConfiguration {

    @Override
    public String getDriver() {
        return "org.h2.Driver";
    }

    @Override
    public String getUrl() {
        return "jdbc:h2:~/test";
    }

    @Override
    public String getUsername() {
        return "sa";
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public Properties getProperties() {
        Properties properties = new Properties();
        properties.put("eclipselink.target-database", "Auto");
        properties.put("eclipselink.logging.level", "FINE");
        properties.put("eclipselink.ddl-generation", "drop-and-create-tables");
        properties.put("eclipselink.persistence-context.flush-mode", "commit");
        properties.put("eclipselink.persistence-context.close-on-commit", "true");
        properties.put("eclipselink.cache.shared.default", "false");
        properties.put("eclipselink.flush", "true");
        properties.put("eclipselink.connection-pool.default.initial", "1");
        properties.put("eclipselink.connection-pool.node2.min", "50");
        properties.put("eclipselink.connection-pool.node2.max", "50");
        properties.put("eclipselink.jdbc.timeout", "5000");
        properties.put("eclipselink.weaving", "STATIC");
        properties.put("eclipselink.weaving.eager", "FALSE");
        properties.put("eclipselink.id-validation", "NEGATIVE");
        return properties;
    }

}
