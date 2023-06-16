package reservio.common.models.response;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import reservio.common.models.embeddable.Position;
import reservio.common.models.embeddable.Price;
import reservio.common.models.embeddable.RelatedEntity;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CreateUpdateTableResponse {

    private Long id;

    private int chair;

    private String type;

    private LocalDateTime createdDate;

    private Price price = null;

    private LocalDateTime updatedDate;

    private String lastUpdatedBy;

    private String createdBy;

    private int version;

    private List<RelatedEntity> relatedEntities;

    private Position position;
}
