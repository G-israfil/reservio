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

    @PatchMapping("/reservation")
    public void updateReservation(){

    }
    @DeleteMapping("reservation/{id}")
    public void deleteReservation(@PathVariable @NonNull final String id){

    }

    @GetMapping("reservation/{id}")
    public void getReservation(@PathVariable @NonNull final String id){

    }


    @PostMapping("/cancelReservation/{id}")
    public void cancelReservation(@PathVariable @NonNull final String id){

    }

    @PostMapping("/postponeReservation/{id}")
    public void postponeReservation(@PathVariable @NonNull final String id){

    }

    @PostMapping("/advanceReservation/{id}")
    public void advanceReservation(@PathVariable @NonNull final String id){

    }
}
