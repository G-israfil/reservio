package reservio.reservationmanagement.reservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reservio.reservationmanagement.reservation.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

}
