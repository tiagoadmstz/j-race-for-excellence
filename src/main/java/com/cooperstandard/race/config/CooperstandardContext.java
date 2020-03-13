package com.cooperstandard.race.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;

@Getter
@Setter
@Configuration
public class CooperstandardContext {

    @Value("${spring.profiles.active:default}")
    private String profile;
    @Value("${cooperstandard.icon}")
    private String icon;
    @Value("${cooperstandard.race-size:1920,1080}")
    private Integer[] raceSize;
    @Value("${cooperstandard.checkered-flag:largada.png}")
    private String checkeredFlag;

}
