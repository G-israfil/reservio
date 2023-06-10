package reservio.subscriptionmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ComponentScan({"reservio.subscriptionmanagement","reservio.common"})
@EnableJpaAuditing
public class SubscriptionManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubscriptionManagementApplication.class, args);
    }
}
