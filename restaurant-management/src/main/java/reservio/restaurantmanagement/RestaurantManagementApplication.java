package reservio.restaurantmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"reservio.restaurantmanagement","reservio.common"})
public class RestaurantManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestaurantManagementApplication.class, args);
	}
}
