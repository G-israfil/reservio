package reservio.restaurantmanagement.restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reservio.restaurantmanagement.restaurant.entity.Restaurant;
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
