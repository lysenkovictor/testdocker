package org.example.configuration;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:properties/endpoint/endpoint.properties"
})
public interface IConfigurationVariables extends Config {

    @Key("url.baseUrl")
    String baseUrl();

    @Key("path.add.owner")
    String pathAddOwner();

}
