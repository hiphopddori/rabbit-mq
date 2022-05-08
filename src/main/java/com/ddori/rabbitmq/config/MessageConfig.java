package com.ddori.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {
    @Bean
    public Queue queueOrder() {
        return new Queue(Constant.QUEUE_ORDER);
    }

    @Bean
    public Queue queueProduct() {
        return new Queue(Constant.QUEUE_PRODUCT);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(Constant.EXCHANGE);
    }

    @Bean
    public Binding orderBinding(Queue queueOrder, TopicExchange exchange) {
        return BindingBuilder.bind(queueOrder).to(exchange).with(Constant.ROUTING_KEY_ORDER);
    }

    @Bean
    public Binding productBinding(Queue queueProduct, TopicExchange exchange) {
        return BindingBuilder.bind(queueProduct).to(exchange).with(Constant.ROUTING_KEY_PRODUCT);
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
