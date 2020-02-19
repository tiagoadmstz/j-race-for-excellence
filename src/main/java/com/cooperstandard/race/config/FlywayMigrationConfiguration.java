package com.cooperstandard.race.config;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.Location;
import org.flywaydb.core.api.configuration.ClassicConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayMigrationConfiguration {

    @Bean
    public Flyway flyway(@Autowired DataSource dataSource) {
        ClassicConfiguration classicConfiguration = new ClassicConfiguration();
        classicConfiguration.setBaselineOnMigrate(true);
        classicConfiguration.setLocations(new Location("/db/migrations"));
        classicConfiguration.setDataSource(dataSource);
        return new Flyway(classicConfiguration);
    }

}
