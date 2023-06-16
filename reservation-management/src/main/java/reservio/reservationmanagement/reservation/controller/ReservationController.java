
package reservio.reservationmanagement.reservation.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reservio.common.models.request.CreateUpdateReservationFormInfo;
import reservio.common.models.response.DashboardAnalyticResponse;
import reservio.reservationmanagement.reservation.entity.Reservation;
import reservio.reservationmanagement.reservation.service.ReservationService;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/reservationManagement")
@Slf4j
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/reservation")
    public ResponseEntity<Reservation> createReservation(@NonNull @RequestBody final CreateUpdateReservationFormInfo formInfo){
        return ResponseEntity.ok(this.reservationService.createReservation(formInfo));
    }

    @PatchMapping("/reservation/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable @NonNull final String id, @NonNull @RequestBody final CreateUpdateReservationFormInfo formInfo) {
        return ResponseEntity.ok(this.reservationService.updateReservation(id, formInfo));
    }

    @DeleteMapping("/reservation/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable @NonNull final String id) {
        this.reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/reservation/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable @NonNull final String id) {

        return ResponseEntity.ok(this.reservationService.getReservation(id));
    }

    @PostMapping("/cancelReservation/{id}")
    public ResponseEntity<Reservation> cancelReservation(@PathVariable @NonNull final String id) {
        return ResponseEntity.ok(this.reservationService.cancelReservation(id));
    }

    @PostMapping("/postponeReservation/{id}")
    public ResponseEntity<Reservation> postponeReservation(@PathVariable @NonNull final String id) {
        return ResponseEntity.ok(this.reservationService.postponeReservation(id));
    }

    @PostMapping("/advanceReservation/{id}")
    public ResponseEntity<Reservation> advanceReservation(@PathVariable @NonNull final String id) {

        return ResponseEntity.ok(this.reservationService.advanceReservation(id));
    }

    @GetMapping("/reservation")
    public ResponseEntity<List<DashboardAnalyticResponse>> advanceReservation(@RequestParam @NonNull final Long restaurantId) {
        return ResponseEntity.ok(this.reservationService.calculateAnalyticForRestaurant(restaurantId));
    }
}

