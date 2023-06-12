package reservio.common.queue.events;

import reservio.common.enums.Status;
import reservio.common.queue.EventMessage;

public class UserEvent extends EventMessage {
    private Status status;
}
