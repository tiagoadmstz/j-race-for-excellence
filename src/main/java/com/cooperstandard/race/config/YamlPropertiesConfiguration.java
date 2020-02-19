package com.cooperstandard.race.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.format.support.DefaultFormattingConversionService;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.regex.Pattern;

@Configuration
public class YamlPropertiesConfiguration {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("application.yml"), new PathResource("config/application.yml"));
        configurer.setIgnoreResourceNotFound(true);
        configurer.setIgnoreUnresolvablePlaceholders(true);
        configurer.setNullValue("");
        configurer.setProperties(yaml.getObject());
        return configurer;
    }

    @Bean
    public static ConversionService conversionService() {
        DefaultFormattingConversionService cs = new DefaultFormattingConversionService();
        cs.addConverter(String.class, Pattern.class, Pattern::compile);
        cs.addConverter(String.class, Image.class, s -> {
            try {
                return new ImageIcon(new ClassPathResource(s).getURL()).getImage();
            } catch (Exception ex) {
            }
            return null;
        });
        cs.addConverter(String.class, URL.class, s -> {
            try {
                return new ClassPathResource(s).getURL();
            } catch (Exception ex) {
            }
            return null;
        });
        return cs;
    }

}
