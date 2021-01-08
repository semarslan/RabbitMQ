package com.semarslan.rabbitmq;

import com.semarslan.rabbitmq.entity.Notification;
import com.semarslan.rabbitmq.producer.NotificationProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class RabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqApplication.class, args);

	}

	@Bean
	CommandLineRunner createNotification(NotificationProducer notificationProducer) {
		return (args -> {
			for (int i=1 ; i <= 5 ; i++) {
				Notification notification = new Notification();

				notification.setId(UUID.randomUUID().toString());
				notification.setCreatedAt(new Date());
				notification.setSeen(Boolean.FALSE);
				notification.setContent("Notification" + i);

				notificationProducer.sendToQueue(notification);
			}
		});
	}
}
