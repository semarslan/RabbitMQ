package com.semarslan.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Kuyrukla konuşan componentleri içerir.
 */
@Configuration
@PropertySource(value = "classpath:./rabbitmqConfig.properties")
public class RabbitMqConfiguration {

    @Value("${rabbit.queue.name}")
    private String queueName;

    @Value("${rabbit.routing.name}")
    private String routingName;

    @Value("${rabbit.exchange.name}")
    private String exchangeName;

    /**
     * @return
     * initialization queue
     */
    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }

    /**
     * @return
     * create exchange
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(exchangeName);
    }

    /**
     * Queue'yu directExchange' bağlar.
     * @param queue
     * @param directExchange
     * @return
     */
    public Binding binding(final Queue queue, DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with(routingName);
    }
}
