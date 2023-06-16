package reservio.common.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import reservio.common.enums.Status;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUpdateOrderFormInfo {

    private String description;

    private String type;
    private Status status;
    private List<CreateUpdateOrderItemFormInfo> orderItems;

    @NonNull
    private Long relatedRestaurantId;
}
