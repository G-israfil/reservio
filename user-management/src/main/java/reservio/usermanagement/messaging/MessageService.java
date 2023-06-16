package reservio.usermanagement.messaging;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reservio.common.contant.Contants;
import reservio.common.contant.QueueName;
import reservio.common.enums.Status;
import reservio.common.queue.EventType;
import reservio.common.queue.events.UserEvent;

import static reservio.common.contant.Contants.CommonQueue.EXCHANGE_NAME;


@Service
@RequiredArgsConstructor
@Slf4j
public class MessageService {

    private final RabbitTemplate rabbitTemplate;
    private final AmqpTemplate amqpTemplate;

    @Value("${app.queue.name}")
    private String queueName;

    public void sendUserCreatedMessage(@NonNull Long userId, @NonNull Status status){
        UserEvent userEvent = new UserEvent();
        userEvent.setId(String.valueOf(userId));
        userEvent.setStatus(status);
        log.info("User created message has been send. ");
        amqpTemplate.convertAndSend(QueueName.DIRECT_EXCHANGE,QueueName.ACCOUNT, userEvent);
    }
}
