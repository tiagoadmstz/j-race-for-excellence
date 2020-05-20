package com.cooperstandard.race.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.awt.*;

@Getter
@Setter
@Configuration
public class CooperstandardContext {

    @Value("${spring.profiles.active}")
    private String profile = "default";
    @Value("${cooperstandard.icon}")
    private Image icon;
    @Value("${cooperstandard.race-updates}")
    private Boolean raceUpdates = false;
    @Value("${cooperstandard.race-updates-time}")
    private Float raceUpdatesTime = 5.0F;
    @Value("${cooperstandard.race-size}")
    private Integer[] raceSize = {1920, 1080};
    @Value("${cooperstandard.checkered-flag}")
    private String checkeredFlag = "largada.png";
    @Value("${cooperstandard.image-path}")
    private String imagePath = "config/images/";

}
