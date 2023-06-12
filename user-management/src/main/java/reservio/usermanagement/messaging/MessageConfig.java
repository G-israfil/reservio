package reservio.usermanagement.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;


@Configuration
public class MessageConfig {
    @Value("${app.queue.name}")
    private String queueName;

    @Bean
    FanoutExchange fanoutExchange() {
        return ExchangeBuilder.fanoutExchange("all-services").durable(true).build();
    }

    @Bean
    Queue queue() {
        return QueueBuilder.durable(queueName).build();
    }

    @Bean
    Binding binding(Queue accountQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(accountQueue).to(fanoutExchange);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(
            @NonNull final ConnectionFactory connectionFactory,
            @NonNull final Jackson2JsonMessageConverter producerJackson2MessageConverter) {

        final var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter);
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {

        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        return new Jackson2JsonMessageConverter(objectMapper);
    }

}
