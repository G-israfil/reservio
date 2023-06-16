package reservio.common.queue.events;

import lombok.Data;
import reservio.common.enums.Status;
import reservio.common.queue.EventMessage;


@Data
public class UserEvent extends EventMessage {
    private Status status;
    private String id;
}
