package reservio.common.models.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import reservio.common.enums.Status;
import reservio.common.models.embeddable.RelatedEntity;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountCreateUpdateResponse {

    private Long id;

    private String name;

    private String description;

    private String type;

    private LocalDateTime createdDate;

    private LocalDateTime lastUpdatedDate;

    private List<RelatedEntity> owners;

    private List<RelatedEntity> paymentMethods;

    private Status status;

    private String updatedBy;

    private int version;
}
