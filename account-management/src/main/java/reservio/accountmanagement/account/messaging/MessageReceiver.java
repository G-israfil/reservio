package reservio.accountmanagement.account.messaging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.lang.NonNull;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import reservio.accountmanagement.account.service.AccountService;
import reservio.common.models.request.CreateUpdateAccountFormInfo;
import reservio.common.queue.EventMessage;
import reservio.common.queue.EventMethod;
import reservio.common.queue.EventType;
import reservio.common.queue.events.AccountEvent;
import reservio.common.queue.events.UserEvent;

import java.util.Map;

import static reservio.common.queue.EventType.ACCOUNT_CREATED;


@Component
@Slf4j
@RequiredArgsConstructor
public class MessageReceiver {
    private final AccountService accountService;
    private final Map<EventType, EventMethod> eventMethods =
            Map.of(
                    ACCOUNT_CREATED, this::createUserAccount);


    @RabbitListener(queues = "${app.queue.name}")
    public void receiveMessage(
            @NonNull final EventMessage eventMessage) {
        EventMethod eventMethod = this.eventMethods.get(ACCOUNT_CREATED);
        eventMethod.run(eventMessage);
    }

    public void logIncomingMessages(EventMessage message) {
        log.info("Account Service Message geldi");
    }

    public void createUserAccount(EventMessage message) {
        log.info("Incoming message:: " + message);
        final UserEvent accountEvent = (UserEvent) message;
        final CreateUpdateAccountFormInfo formInfo = new CreateUpdateAccountFormInfo();
        formInfo.setUserId(String.valueOf(accountEvent.getId()));
        formInfo.setDescription("Created by the system. Default account.");
        accountService.createAccount(formInfo);
    }

}
