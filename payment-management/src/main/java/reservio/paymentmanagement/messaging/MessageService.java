package reservio.paymentmanagement.messaging;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reservio.common.queue.EventType;
import reservio.common.queue.events.PaymentEvent;


@Service
@RequiredArgsConstructor
public class MessageService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${app.queue.name}")
    private String queueName;

    public void sendAccountCreatedMessage(@NonNull Long accountId){
        PaymentEvent accountCreatedEvent = new PaymentEvent();
        accountCreatedEvent.setId(String.valueOf(accountId));
        rabbitTemplate.convertAndSend(queueName,accountCreatedEvent,message -> {
            message.getMessageProperties().setHeader("x-event-type", EventType.ACCOUNT_CREATED);
            return message;
        });
    }
}
