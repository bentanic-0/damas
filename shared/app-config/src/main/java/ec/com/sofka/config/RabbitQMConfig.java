package ec.com.sofka.config;

import ec.com.sofka.utils.enums.EventsEnum;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Objects;

@Configuration
@PropertySource("classpath:appConfig.properties")
public class RabbitQMConfig {

    private final Environment environment;

    public RabbitQMConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate customRabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public DirectExchange errorLogExchange() {
        return new DirectExchange(environment.getProperty("log.exchange"));
    }

    @Bean
    public Queue errorLogQueue() {
        return new Queue(Objects.requireNonNull(environment.getProperty("log.queue")), true);
    }

    @Bean
    public Binding errorLogBinding(Queue errorLogQueue, DirectExchange errorLogExchange) {
        return BindingBuilder.bind(errorLogQueue).to(errorLogExchange).with(environment.getProperty("log.routingKey"));
    }

    @Bean
    public DirectExchange userCreateExchange() {
        return new DirectExchange(environment.getProperty(EventsEnum.USER_CREATED.getExchange()));
    }

    @Bean
    public Queue userCreateQueue() {
        return new Queue(Objects.requireNonNull(environment.getProperty(EventsEnum.USER_CREATED.getQueue())), true);
    }

    @Bean
    public Binding userCreateBinding(Queue userCreateQueue, DirectExchange userCreateExchange) {
        return BindingBuilder.bind(userCreateQueue).to(userCreateExchange).with(environment.getProperty(EventsEnum.USER_CREATED.getRoutingKey()));
    }

    @Bean
    public DirectExchange userUpdateExchange() {
        return new DirectExchange(environment.getProperty(EventsEnum.USER_UPDATED.getExchange()));
    }

    @Bean
    public Queue userUpdateQueue() {
        return new Queue(Objects.requireNonNull(environment.getProperty(EventsEnum.USER_UPDATED.getQueue())), true);
    }

    @Bean
    public Binding userUpdateBinding(Queue userUpdateQueue, DirectExchange userUpdateExchange) {
        return BindingBuilder.bind(userUpdateQueue).to(userUpdateExchange).with(environment.getProperty(EventsEnum.USER_UPDATED.getRoutingKey()));
    }
}







   