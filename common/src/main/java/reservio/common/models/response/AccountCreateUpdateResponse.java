package reservio.common.models.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import reservio.common.enums.STATUS;
import reservio.common.models.RelatedEntity;

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

    private STATUS status;

    private String updatedBy;

    private int version;
}
