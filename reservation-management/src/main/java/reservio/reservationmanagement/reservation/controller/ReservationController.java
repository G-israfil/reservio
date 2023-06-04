
package reservio.reservationmanagement.reservation.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reservio.common.models.request.CreateUpdateReservationFormInfo;
import reservio.reservationmanagement.reservation.service.ReservationService;

@Controller
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/reservationManagement")
@Slf4j
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/reservation")
    public ResponseEntity createReservation(@NonNull @RequestBody final CreateUpdateReservationFormInfo formInfo){
        return ResponseEntity.ok(this.reservationService.createReservation(formInfo));
    }

    @PatchMapping("/reservation/{id}")
    public ResponseEntity updateReservation(@PathVariable @NonNull final String id, @NonNull @RequestBody final CreateUpdateReservationFormInfo formInfo) {
        return ResponseEntity.ok(this.reservationService.updateReservation(id, formInfo));
    }

    @DeleteMapping("/reservation/{id}")
    public ResponseEntity deleteReservation(@PathVariable @NonNull final String id) {
        this.reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/reservation/{id}")
    public ResponseEntity getReservation(@PathVariable @NonNull final String id) {
        this.reservationService.getReservation(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/cancelReservation/{id}")
    public ResponseEntity cancelReservation(@PathVariable @NonNull final String id) {
        this.reservationService.cancelReservation(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/postponeReservation/{id}")
    public ResponseEntity postponeReservation(@PathVariable @NonNull final String id) {
        this.reservationService.postponeReservation(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/advanceReservation/{id}")
    public ResponseEntity advanceReservation(@PathVariable @NonNull final String id) {
        this.reservationService.advanceReservation(id);
        return ResponseEntity.noContent().build();
    }
}

