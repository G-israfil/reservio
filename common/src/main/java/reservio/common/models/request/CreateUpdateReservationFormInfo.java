package reservio.common.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUpdateReservationFormInfo {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long tableId;
    private Long restaurantId;
    private int reservationSize;
    private int duration;
    private String description;
}
