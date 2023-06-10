package reservio.productcatalogmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan({"reservio.productcatalogmanagement","reservio.common"})
public class ProductCatalogManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductCatalogManagementApplication.class, args);
    }

}
