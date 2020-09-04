package org.example.configuration;

import org.aeonbits.owner.ConfigFactory;

public class Property {

    private Property() {
    }
    public static final IConfigurationVariables props = ConfigFactory.create(IConfigurationVariables.class, System.getenv());

}
