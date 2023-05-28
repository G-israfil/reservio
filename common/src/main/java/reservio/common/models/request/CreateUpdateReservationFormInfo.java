package reservio.common.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CreateUpdateReservationFormInfo {

    private String state;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String tableId;
}
