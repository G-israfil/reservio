package reservio.accountmanagement.account.messaging;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reservio.common.enums.Status;
import reservio.common.queue.EventType;
import reservio.common.queue.events.AccountEvent;

import static reservio.common.contant.Contants.CommonQueue.EXCHANGE_NAME;


@Service
@RequiredArgsConstructor
public class MessageService {

    private final RabbitTemplate rabbitTemplate;
    private final AmqpTemplate amqpTemplate;

    @Value("${app.queue.name}")
    private String queueName;

    public void sendAccountCreatedMessage(@NonNull Long accountId, @NonNull Status status){
        AccountEvent accountCreatedEvent = new AccountEvent();
        accountCreatedEvent.setId(accountId);
        accountCreatedEvent.setStatus(status);
        amqpTemplate.convertAndSend(EXCHANGE_NAME,"*",accountCreatedEvent,message -> {
            message.getMessageProperties().setHeader("x-event-type", EventType.ACCOUNT_CREATED);
            return message;
        });
    }
}
