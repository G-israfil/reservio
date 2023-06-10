package reservio.paymentmanagement.messaging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.lang.NonNull;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import reservio.common.queue.EventMessage;
import reservio.common.queue.EventMethod;
import reservio.common.queue.EventType;

import java.util.Map;

import static reservio.common.queue.EventType.ACCOUNT_CREATED;


@Component
@Slf4j
public class MessageReceiver {

    private final Map<EventType, EventMethod> eventMethods =
            Map.of(
                    ACCOUNT_CREATED,this::logIncomingMessages);


    @RabbitListener(queues = "${app.queue.name}")
    public void receiveMessage(
            @NonNull final EventMessage eventMessage,
            @NonNull @Header("x-event-type")final EventType eventType) {
        EventMethod eventMethod = this.eventMethods.get(ACCOUNT_CREATED);
        eventMethod.run(eventMessage);
    }

    public void logIncomingMessages(EventMessage message){
        log.info("Message geldi");
    }

}
