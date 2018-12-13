package com.javanotificationbots.worker.dataprocessor.impl;

import com.javanotificationbots.worker.dataprocessor.SlackService;
import com.google.gson.Gson;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.util.HashMap;
import java.util.Map;

public class SlackServiceImpl implements SlackService
{
    private final String slackWebhookUrl;

    private CloseableHttpClient httpClient;

    public SlackServiceImpl( String slackWebhookUrl )
    {
        this.httpClient = HttpClients.createDefault();
        this.slackWebhookUrl = slackWebhookUrl;
    }
    /**
     * Submits the prepared notification to Slack
     * @param message
     */
    @Override
    public void submitSlackNotification( String message )
    {
        try {
            System.out.println("Sending Slack Notification");

            HttpPost httpPost = new HttpPost( slackWebhookUrl );
            httpPost.setEntity( new StringEntity(getFormattedSlackPayload( message ) ) );

            setSlackHeaders( httpPost );

            CloseableHttpResponse response = httpClient.execute( httpPost );

            System.out.println( response.getStatusLine() );
        } catch ( Exception ex) {
            System.out.println( ex.toString() );
        }
    }
    /**
     * Adds required headers for Slack notifications
     * @param httpPost
     */
    private void setSlackHeaders( HttpPost httpPost )
    {
        httpPost.addHeader( "Content-Type", "application/json;" );
    }

    /**
     * Formats the received notification text for Slack Notifications
     * @param text
     * @return
     */
    private String getFormattedSlackPayload( String text )
    {
        System.out.println("Formatting slack payload");
        Map<String, Object> payload = new HashMap<>();

        payload.put( "username", "javanotificationbots" );
        payload.put( "text", text );

        return new Gson().toJson(payload);
    }
}
