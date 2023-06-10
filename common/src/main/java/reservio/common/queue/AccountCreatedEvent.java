package reservio.common.queue;

import lombok.Data;

@Data
public class AccountCreatedEvent extends EventMessage{
    private Long id;
}
