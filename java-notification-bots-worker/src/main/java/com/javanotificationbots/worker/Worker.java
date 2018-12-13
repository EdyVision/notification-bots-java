package com.javanotificationbots.worker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Worker
{
    private static final Logger LOGGER = LoggerFactory.getLogger( Worker.class );

    public static void main( String[] args )
    {
        SpringApplication.run( Worker.class, args );
        LOGGER.info( "************ Worker App Started Successfully ************" );
    }
}
