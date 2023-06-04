package reservio.common.models;

import jakarta.persistence.Embeddable;
import lombok.Data;


@Data
@Embeddable
public class RoleRef {
    private String name;
    private String id;
}
