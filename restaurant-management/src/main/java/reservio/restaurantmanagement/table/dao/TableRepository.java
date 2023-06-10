package reservio.restaurantmanagement.table.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import reservio.restaurantmanagement.table.entity.RTable;

public interface TableRepository extends JpaRepository<RTable,Long> {
}
