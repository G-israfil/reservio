package reservio.common.models.referances;

import jakarta.persistence.Embeddable;
import lombok.Data;


@Data
@Embeddable
public class RoleRef {
    private String name;
    private String id;
}
