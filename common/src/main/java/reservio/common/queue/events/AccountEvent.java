package reservio.common.queue.events;

import lombok.Data;
import lombok.EqualsAndHashCode;
import reservio.common.enums.Status;
import reservio.common.queue.EventMessage;


@EqualsAndHashCode(callSuper = true)
@Data
public class AccountEvent extends EventMessage {
    private Status status;
    private Long id;
}
