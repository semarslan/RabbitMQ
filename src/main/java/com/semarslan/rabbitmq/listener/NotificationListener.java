package com.semarslan.rabbitmq.listener;

import com.semarslan.rabbitmq.entity.Notification;

public class NotificationListener {

    /**
     * uyruktaki notificationları dinler, NotificationProducer vasıtasıyla.
     * @param notification
     */
    public void handleMessage(Notification notification) {
        System.out.println(notification.toString());
    }
}
