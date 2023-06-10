package reservio.restaurantmanagement.floor.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import reservio.restaurantmanagement.table.entity.RTable;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "floors")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@EntityListeners(AuditingEntityListener.class)
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price")
    private Double price;

    @Column(name = "owner")
    private String owner;

    @OneToMany(cascade = CascadeType.ALL)
    private List<RTable> tables;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "level")
    private int level;
}
