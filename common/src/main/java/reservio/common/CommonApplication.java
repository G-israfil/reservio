package reservio.common;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reservio.common.mappers.ModelMapperHelper;

@SpringBootApplication
@RequiredArgsConstructor
public class CommonApplication {
    public static void main(String[] args) {


        SpringApplication.run(CommonApplication.class, args);
    }

}
