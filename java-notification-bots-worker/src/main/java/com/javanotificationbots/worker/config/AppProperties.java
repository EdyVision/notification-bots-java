package com.javanotificationbots.worker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

import static org.postgresql.shaded.com.ongres.scram.common.util.Preconditions.checkNotNull;

public class AppProperties {

    @Autowired
    private Environment environment;

    private java.util.Properties properties = new java.util.Properties();

    public static final String SLACK_WEBHOOK = "SLACK_WEBHOOK";

    @PostConstruct
    public void loadSettings()
    {
        populateStringProperty( properties, SLACK_WEBHOOK );
    }

    private void populateStringProperty(java.util.Properties properties, String key )
    {
        String value = environment.getProperty( key, String.class );
        checkNotNull( value, String.format( "%s not set.", key ) );
        properties.put( key, value );
    }

    public String getProperty( String key )
    {
        return properties.getProperty( key );
    }
}
