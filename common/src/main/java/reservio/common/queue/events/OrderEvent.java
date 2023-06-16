package reservio.common.queue.events;

import lombok.Data;
import reservio.common.queue.EventMessage;

@Data
public class OrderEvent extends EventMessage {
    String id;
}
