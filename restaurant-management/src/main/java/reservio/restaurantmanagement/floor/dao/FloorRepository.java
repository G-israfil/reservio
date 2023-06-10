package reservio.restaurantmanagement.floor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reservio.restaurantmanagement.floor.entity.Floor;

@Repository
public interface FloorRepository extends JpaRepository<Floor,Long> {
}
