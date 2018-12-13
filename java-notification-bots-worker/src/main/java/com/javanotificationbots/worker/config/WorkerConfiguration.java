package com.javanotificationbots.worker.config;

import com.javanotificationbots.worker.dataprocessor.NotificationService;
import com.javanotificationbots.worker.dataprocessor.SlackService;
import com.javanotificationbots.worker.dataprocessor.impl.NotificationServiceImpl;
import com.javanotificationbots.worker.dataprocessor.impl.SlackServiceImpl;
import com.javanotificationbots.worker.scheduler.NotificationScheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;

/**
 * List all your Spring configurations here
 */
@Configuration
@PropertySource( { "classpath:application.properties" } )
public class WorkerConfiguration
{
    @Bean
    public AppProperties appProperties()
    {
        return new AppProperties();
    }

    @Bean
    @DependsOn("appProperties")
    public SlackService slackService(AppProperties appProperties )
    {
        return new SlackServiceImpl(
                appProperties.getProperty( "SLACK_WEBHOOK" )
        );
    }

    @Bean
    @DependsOn("appProperties")
    public NotificationService notificationService(AppProperties appProperties, SlackService slackService )
    {
        return new NotificationServiceImpl(
                slackService
        );
    }

    @Bean
    public NotificationScheduler notificationScheduler( NotificationService notificationService )
    {
        return new NotificationScheduler( notificationService );
    }

}
