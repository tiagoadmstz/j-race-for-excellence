package com.cooperstandard.race.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.PathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class SpringContext {

    private static final String packages = "config,factories,dal";
    private static final AnnotationConfigApplicationContext context = loadContext(getProfile());

    public static ApplicationContext getContext() {
        return context;
    }

    private static AnnotationConfigApplicationContext loadContext(String profile) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.setAllowBeanDefinitionOverriding(true);
        applicationContext.getEnvironment().setActiveProfiles(profile);
        applicationContext.scan(getBasePackages());
        applicationContext.refresh();
        return applicationContext;
    }

    public static String[] getBasePackages() {
        return Arrays.stream(packages.split(",")).map(pkg -> "com.cooperstandard.race.".concat(pkg)).toArray(String[]::new);
    }

    public static String getProfile() {
        try {
            return Files.readAllLines(new PathResource("config/application.yml").getFile().toPath()).stream()
                    .filter(s -> s.contains("active")).reduce("", (s, s2) -> s = s2.replaceAll("active: ", "").trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "default";
    }

}
