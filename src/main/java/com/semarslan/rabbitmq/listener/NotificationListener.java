package com.semarslan.rabbitmq.listener;

import com.semarslan.rabbitmq.entity.Notification;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//@PropertySource(value = "classpath:./rabbitmqConfig.properties")
@RequiredArgsConstructor
public class NotificationListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationListener.class);

    /**
     * uyruktaki notificationları dinler, NotificationProducer vasıtasıyla.
     * @param notification
     */

    @RabbitListener(queues = {"queue"})
    public void handleOnMessage(Notification notification) {
        LOGGER.info("Notification Listener : " + notification.toString());
    }
}
