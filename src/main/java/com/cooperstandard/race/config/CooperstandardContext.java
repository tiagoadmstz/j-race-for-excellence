package com.cooperstandard.race.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class CooperstandardContext {

    @Value("${spring.profiles.active:default}")
    private String profile;
    @Value("${cooperstandard.icon}")
    private String icon;

}
