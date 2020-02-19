package com.cooperstandard.race.dal.interfaces;

import java.util.Properties;

public interface DatabaseConfiguration {

    String getDriver();

    String getUrl();

    String getUsername();

    String getPassword();

    Properties getProperties();

}
