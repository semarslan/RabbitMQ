package com.semarslan.rabbitmq.producer;

import com.semarslan.rabbitmq.entity.Notification;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;



@Component
@RequiredArgsConstructor
public class NotificationProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationProducer.class);

    private final Queue queue;

    private final RabbitTemplate rabbitTemplate;

    /**
     * @param notification
     *
     * Kuyruğa yazılacak mesajı gönderir.
     */
    public void sendToQueue(Notification notification) {
        LOGGER.info("Notification send : " + notification);
        rabbitTemplate.convertAndSend(queue.getActualName(), notification);
    }

}
