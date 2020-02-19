package com.cooperstandard.race.factories;

import com.cooperstandard.race.dal.config.H2Configuration;
import com.cooperstandard.race.dal.config.SQLServerConfiguration;
import com.cooperstandard.race.dal.interfaces.DatabaseConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
public class BeanFactory {

    @Bean
    @Profile("dev")
    public DatabaseConfiguration h2Configuration() {
        return new H2Configuration();
    }

    @Bean()
    @Profile("prod")
    public DatabaseConfiguration sqlServerConfiguration() {
        return new SQLServerConfiguration();
    }

}
