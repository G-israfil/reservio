package reservio.reservationmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.scheduling.annotation.EnableScheduling;
import reservio.common.models.request.CreateUpdateReservationFormInfo;
import reservio.common.util.CommonUtils;

@SpringBootApplication
@EnableScheduling
@ComponentScan({"reservio.reservationmanagement","reservio"})
public class ReservationManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationManagementApplication.class, args);
    }

}
