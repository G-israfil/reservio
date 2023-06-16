package reservio.common.models.response;

import jakarta.persistence.*;
import lombok.Data;
import reservio.common.models.embeddable.Price;

import java.util.List;

@Data
public class CreateUpdateFloorResponse {

    private Long id;

    private Price price;

    private String owner;

    private List<CreateUpdateTableResponse> tables;

    private int capacity;

    private int level;
}
