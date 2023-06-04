package reservio.accountmanagement.account.entitiy;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import reservio.common.enums.ACCOUNT_TYPE;
import reservio.common.enums.STATUS;
import reservio.common.models.RelatedEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Table(name = "accounts")
@Entity
@Data
public class Account {

    @Id
    @Column(name = "accountId")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ACCOUNT_TYPE type;

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
    private STATUS status;

    @Column(name = "updatedBy")
    private String updatedBy;

    @Column(name = "enabled")
    private Boolean enabled = false;

    @Column(name = "suspended")
    private Boolean suspended = false;

    @Column(name = "trustScore")
    @Enumerated(EnumType.STRING)
    private String trustScore;

    @Column(name = "version")
    @Version
    private int version;


    public Account(){
        id = UUID.fromString(UUID.randomUUID().toString()).getMostSignificantBits();
    }

}
