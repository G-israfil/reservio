package reservio.reservationmanagement.reservation.schedular;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reservio.reservationmanagement.reservation.service.ReservationService;

@Component
public class ReservationScheduler {

    private final ReservationService reservationService;

    public ReservationScheduler(ReservationService reservationService){
        this.reservationService = reservationService;
    }
    @Scheduled(fixedRate = 10*60*1000)
    public void cancelledReservationIfTimePassed() {
        reservationService.findAndCancelledReservations();
    }
}
