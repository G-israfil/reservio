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

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservationService {
    private final ReservationRepository repository;
    private final ModelMapperHelper modelMapperHelper;

    public Reservation createReservation(@NonNull @RequestBody final CreateUpdateReservationFormInfo formInfo) {
        final Reservation reservation = modelMapperHelper.map(formInfo, Reservation.class);
        reservation.setStatus(STATUS.ACTIVE);
        return this.repository.save(reservation);
    }


    public Reservation updateReservation(@PathVariable @NonNull final String id, @NonNull @RequestBody final CreateUpdateReservationFormInfo formInfo) {
        final Optional<Reservation> optionalReservation = this.repository.findById(Long.parseLong(id));
        if (optionalReservation.isPresent()) {
            final Reservation reservation = optionalReservation.get();
            reservation.setStartDate(formInfo.getStartDate());
            reservation.setEndDate(formInfo.getEndDate());
            reservation.setReservationSize(formInfo.getReservationSize());
            reservation.setDuration(formInfo.getDuration());
            reservation.setStatus(STATUS.IN_PROGRESS);
            reservation.setDescription(formInfo.getDescription());
            return this.repository.save(reservation);
        }

        throw new NotFoundException("Reservation not found with given id: " + id);
    }



    public void deleteReservation(@PathVariable @NonNull final String id) {
        final Optional<Reservation> optionalReservation = this.repository.findById(Long.parseLong(id));
        if (optionalReservation.isPresent()) {
            this.repository.deleteById(Long.parseLong(id));
            return;
        }
            throw new NotFoundException("Reservation not found with given id: " + id);
    }


    public Reservation getReservation(@PathVariable @NonNull final String id) {
        final Optional<Reservation> optionalReservation = this.repository.findById(Long.parseLong(id));
        if (optionalReservation.isPresent()) {
            return optionalReservation.get();
        }

        throw new NotFoundException("Reservation not found with given id: " + id);
    }

    public Reservation cancelReservation(@PathVariable @NonNull final String id) {
        final Optional<Reservation> optionalReservation = this.repository.findById(Long.parseLong(id));
        if (optionalReservation.isPresent()) {
            final Reservation reservation = optionalReservation.get();
            reservation.setStatus(STATUS.CANCELLED);
            return this.repository.save(reservation);
        }

        throw new NotFoundException("Reservation not found with given id: " + id);
    }



    public void postponeReservation(@PathVariable @NonNull final String id) {
        final Optional<Reservation> optionalReservation = this.repository.findById(Long.parseLong(id));
        if (optionalReservation.isPresent()) {
            final Reservation reservation = optionalReservation.get();
            LocalDateTime newStartDate = reservation.getStartDate().plusDays(1);
            LocalDateTime newEndDate = reservation.getEndDate().plusDays(1);
            //TODO: Aynı tarih ve saat araığında başka rezervasyon var mı kontrol edilecek.
            reservation.setStartDate(newStartDate);
            reservation.setEndDate(newEndDate);

            this.repository.save(reservation);
        } else {
            throw new NotFoundException("Reservation not found with given id: " + id);
        }
    }

    public void advanceReservation(@PathVariable @NonNull final String id) {
        final Optional<Reservation> optionalReservation = this.repository.findById(Long.parseLong(id));
        if (optionalReservation.isPresent()) {
            final Reservation reservation = optionalReservation.get();
            LocalDateTime newStartDate = reservation.getStartDate().minusDays(1);
            LocalDateTime newEndDate = reservation.getEndDate().minusDays(1);
            //TODO: Aynı tarih ve saat araığında başka rezervasyon var mı kontrol edilecek.
            reservation.setStartDate(newStartDate);
            reservation.setEndDate(newEndDate);

            this.repository.save(reservation);
        } else {
            throw new NotFoundException("Reservation not found with given id: " + id);
        }
    }
}
