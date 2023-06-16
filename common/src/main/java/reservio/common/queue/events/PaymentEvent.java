package reservio.common.queue.events;

import lombok.Data;
import reservio.common.queue.EventMessage;

@Data
public class PaymentEvent extends EventMessage {
    private String id;
    private String status;
}
