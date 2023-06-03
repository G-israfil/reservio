package reservio.subscriptionmanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @Column(name = "subscription_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "duration")
    private String duration;

    @Column(name = "term")
    private String term;

    @Column(name = "createdDate")
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "updatedDate")
    @LastModifiedDate
    private LocalDateTime updatedDate;


    @Column(name = "startedDate")
    private LocalDateTime startedDate;

    @Column(name = "expectedExpiryDate")
    private LocalDateTime expectedExpiryDate;

    @Column(name = "currentCycle")
    private String currentCycle;

    @Column(name = "totalCycle")
    private String totalCycle;

}
