package reservio.accountmanagement.account.messaging;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reservio.common.queue.events.AccountCreatedEvent;
import reservio.common.queue.EventType;


@Service
@RequiredArgsConstructor
public class MessageService {

    private final RabbitTemplate rabbitTemplate;
    private final AmqpTemplate amqpTemplate;

    @Value("${app.queue.name}")
    private String queueName;

    public void sendAccountCreatedMessage(@NonNull Long accountId){
        AccountCreatedEvent accountCreatedEvent = new AccountCreatedEvent();
        accountCreatedEvent.setId(accountId);
        amqpTemplate.convertAndSend("all-services","*",accountCreatedEvent,message -> {
            message.getMessageProperties().setHeader("x-event-type", EventType.ACCOUNT_CREATED);
            return message;
        });
    }
}
