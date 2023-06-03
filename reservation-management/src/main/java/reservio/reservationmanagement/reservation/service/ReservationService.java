package reservio.reservationmanagement.reservation.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import reservio.common.enums.STATUS;
import reservio.common.exceptions.NotFoundException;
import reservio.common.mappers.ModelMapperHelper;
import reservio.common.models.request.CreateUpdateReservationFormInfo;
import reservio.reservationmanagement.reservation.dao.ReservationRepository;
import reservio.reservationmanagement.reservation.entity.Reservation;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservationService {
    private final ReservationRepository repository;
    private final ModelMapperHelper modelMapperHelper;
    public Reservation createReservation(@NonNull @RequestBody final CreateUpdateReservationFormInfo formInfo) {
        final Reservation reservation =  modelMapperHelper.map(formInfo,Reservation.class);
        reservation.setStatus(STATUS.ACTIVE);
        return this.repository.save(reservation);
    }


    public void updateReservation() {

    }

    public void deleteReservation(@PathVariable @NonNull final String id) {

    }

    public void getReservation(@PathVariable @NonNull final String id) {

    }


    public Reservation cancelReservation(@PathVariable @NonNull final String id) {
        final Optional<Reservation> optionalReservation =  this.repository.findById(Long.parseLong(id));
        if(optionalReservation.isPresent()){
            final Reservation reservation = optionalReservation.get();
            reservation.setStatus(STATUS.CANCELLED);
            return this.repository.save(reservation);
        }

        throw new NotFoundException("Reservation not found with given id: " + id);
    }


    public void postponeReservation(@PathVariable @NonNull final String id) {

    }

    public void advanceReservation(@PathVariable @NonNull final String id) {

    }
}
