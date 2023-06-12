package reservio.common.queue.events;

import lombok.Data;
import reservio.common.enums.Status;
import reservio.common.queue.EventMessage;

@Data
public class SubscriptionEvent extends EventMessage {
    private Status status;
}
