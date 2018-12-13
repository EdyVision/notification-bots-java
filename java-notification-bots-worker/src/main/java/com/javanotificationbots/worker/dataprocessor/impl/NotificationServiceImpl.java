package com.javanotificationbots.worker.dataprocessor.impl;

import com.javanotificationbots.worker.dataprocessor.NotificationService;
import com.javanotificationbots.worker.dataprocessor.SlackService;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


/**
 * Notification class that handles Slack notifications and in the future, email.
 */
public class NotificationServiceImpl implements NotificationService
{
    private CloseableHttpClient httpClient;

    private final SlackService slackService;

    public NotificationServiceImpl( SlackService slackService )
    {
        this.slackService = slackService;
        this.httpClient = HttpClients.createDefault();
    }

    /**
     *
     */
    @Override
    public void initiateNotifications()
    {
        submitNotifications();
    }

    /**
     * Submits notification to Slack via SlackService.
     */
    private void submitNotifications()
    {
        try {
            System.out.println("Preparing Slack Notification...");

            // You would assign the following to whatever returned and formatted string
            // from a service of your choosing
            String notification = "Notification Success";

            slackService.submitSlackNotification( notification );

        } catch ( Exception ex) {
            System.out.println(ex);
        }

    }
}
