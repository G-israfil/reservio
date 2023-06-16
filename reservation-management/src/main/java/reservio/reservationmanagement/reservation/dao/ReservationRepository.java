package reservio.reservationmanagement.reservation.dao;

import jakarta.transaction.Transactional;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reservio.common.enums.Status;
import reservio.reservationmanagement.reservation.entity.Reservation;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    @Query("SELECT r FROM Reservation r WHERE r.startDate <= :startDate AND r.endDate >= :endDate AND r.tableId = :tableId AND r.status NOT IN ('CANCELLED', 'COMPLETED')")
    List<Reservation> listReservations(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, @Param("tableId") Long tableId);


    List<Reservation> findByRestaurantIdAndStatusIsNot(@NonNull Long restaurantId, @NonNull Status status);


    @Modifying
    @Query("update Reservation r set r.status = :status where r.startDate <= :date and r.status = 'ACTIVE'")
    void cancelReservationIfTimeIsPassed(@NonNull @Param("date") LocalDateTime date,@NonNull @Param("status") Status status);
}
