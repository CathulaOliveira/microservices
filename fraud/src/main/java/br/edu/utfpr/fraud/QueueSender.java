package br.edu.utfpr.fraud;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class QueueSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("exchange1")
    private String exchange;

    @Value("routing-key1")
    private String routingKey;

    public String send(String order) {
        rabbitTemplate.convertAndSend(exchange, routingKey, order);
        return "mensagem enviada";
    }
}
