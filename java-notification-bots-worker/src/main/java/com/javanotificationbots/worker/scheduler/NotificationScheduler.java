package com.javanotificationbots.worker.scheduler;

import com.javanotificationbots.worker.dataprocessor.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

public class NotificationScheduler
{
    /**
     *   Run job every 30 minutes
     */
    private static final String CRON = "0 0/30 * * * *";

    Logger LOGGER = LoggerFactory.getLogger( NotificationScheduler.class );
    private final NotificationService notificationService;

    public NotificationScheduler( NotificationService notificationService )
    {
        this.notificationService = notificationService;
    }

    @Scheduled( cron = CRON)
    public void execute()
    {

        LOGGER.info( "Initializing Scheduled Notifications...");

        notificationService.initiateNotifications();

    }
}