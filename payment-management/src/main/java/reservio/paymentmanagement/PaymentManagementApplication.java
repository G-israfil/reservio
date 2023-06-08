package reservio.paymentmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"reservio.paymentmanagement","reservio.common"})
public class PaymentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentManagementApplication.class, args);
    }

}
