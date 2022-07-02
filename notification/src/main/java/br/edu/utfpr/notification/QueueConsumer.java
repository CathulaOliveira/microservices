package br.edu.utfpr.notification;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {

    @RabbitListener(queues = {"fila1"})
    public void receive(@Payload String fileBody) {
        System.out.println("Message " + fileBody);
    }
}
