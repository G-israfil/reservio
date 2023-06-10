package reservio.accountmanagement.account.entitiy;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import reservio.common.enums.AccountType;
import reservio.common.enums.Status;
import reservio.common.models.embeddable.RelatedEntity;
import reservio.common.util.CommonUtils;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "accounts")
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Account {
    @Id
    @Column(name = "accountId")
    private Long id = CommonUtils.generateUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private AccountType type;

    @Column(name = "createdDate")
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "lastUpdatedDate")
    @LastModifiedDate
    private LocalDateTime lastUpdatedDate;

    @ElementCollection
    private List<RelatedEntity> owners;

    @ElementCollection
    private List<RelatedEntity> paymentMethods;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "updatedBy")
    private String updatedBy;

    @Column(name = "enabled")
    private Boolean enabled = false;

    @Column(name = "suspended")
    private Boolean suspended = false;

    @Column(name = "trustScore")
    private int trustScore;

    @Version
    private int version;
}
