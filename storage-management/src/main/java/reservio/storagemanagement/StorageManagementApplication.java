package reservio.storagemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"reservio.storagemanagement","reservio.common"})
public class StorageManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(StorageManagementApplication.class, args);
    }
}
