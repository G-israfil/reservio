package reservio.reservationmanagement.reservation.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import reservio.common.enums.Status;
import reservio.common.exceptions.NotFoundException;
import reservio.common.mappers.ModelMapperHelper;
import reservio.common.models.request.CreateUpdateReservationFormInfo;
import reservio.common.models.response.DashboardAnalyticResponse;
import reservio.reservationmanagement.reservation.dao.ReservationRepository;
import reservio.reservationmanagement.reservation.entity.Reservation;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservationService {
    private final ReservationRepository repository;
    private final ModelMapperHelper modelMapperHelper;


    private Boolean checkDateIsAcceptable(@NonNull final LocalDateTime start,@NonNull final LocalDateTime end, @NonNull final Long taleId){
        List<Reservation> reservations = repository.listReservations(start,end,taleId);

        if(ObjectUtils.isEmpty(reservations)) return true;
        return false;
    }

    public Reservation createReservation(@NonNull @RequestBody final CreateUpdateReservationFormInfo formInfo) {
        final Reservation reservation = modelMapperHelper.map(formInfo, Reservation.class);
        if(!checkDateIsAcceptable(reservation.getStartDate(),reservation.getEndDate(),reservation.getTableId())) throw new RuntimeException("Table is already reserved");
        reservation.setDay(LocalDateTime.now().getDayOfMonth());
        reservation.setMonth(LocalDateTime.now().getMonthValue());
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        Integer weekOfYear = LocalDateTime.now().get(weekFields.weekOfYear());
        reservation.setWeek(weekOfYear);
        reservation.setStatus(Status.ACTIVE);
        return this.repository.save(reservation);
    }

    public Reservation updateReservation(@PathVariable @NonNull final String id, @NonNull @RequestBody final CreateUpdateReservationFormInfo formInfo) {
        final Optional<Reservation> optionalReservation = this.repository.findById(Long.parseLong(id));
        if (optionalReservation.isPresent()) {
            final Reservation reservation = optionalReservation.get();
            if(Objects.nonNull(formInfo.getStartDate())){
                if(!checkDateIsAcceptable(formInfo.getStartDate(),reservation.getEndDate(),reservation.getTableId())) throw new RuntimeException("Table is already reserved");
                reservation.setStartDate(formInfo.getStartDate());
            }
            if(Objects.nonNull(formInfo.getEndDate())){
                if(!checkDateIsAcceptable(reservation.getStartDate(),formInfo.getEndDate(),reservation.getTableId())) throw new RuntimeException("Table is already reserved");
                reservation.setEndDate(formInfo.getEndDate());
            }

            reservation.setReservationSize(formInfo.getReservationSize());
            reservation.setDuration(formInfo.getDuration());
            reservation.setStatus(Status.IN_PROGRESS);
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
            reservation.setStatus(Status.CANCELLED);
            return this.repository.save(reservation);
        }

        throw new NotFoundException("Reservation not found with given id: " + id);
    }



    public Reservation postponeReservation(@PathVariable @NonNull final String id) {
        final Optional<Reservation> optionalReservation = this.repository.findById(Long.parseLong(id));
        if (optionalReservation.isPresent()) {
            final Reservation reservation = optionalReservation.get();
            LocalDateTime newStartDate = reservation.getStartDate().plusDays(1);
            LocalDateTime newEndDate = reservation.getEndDate().plusDays(1);
            if(!checkDateIsAcceptable(newStartDate,newEndDate,reservation.getTableId())) throw new RuntimeException("Table is already reserved");
            reservation.setStartDate(newStartDate);
            reservation.setEndDate(newEndDate);

            return this.repository.save(reservation);
        } else {
            throw new NotFoundException("Reservation not found with given id: " + id);
        }
    }

    public Reservation advanceReservation(@PathVariable @NonNull final String id) {
        final Optional<Reservation> optionalReservation = this.repository.findById(Long.parseLong(id));
        if (optionalReservation.isPresent()) {
            final Reservation reservation = optionalReservation.get();
            LocalDateTime newStartDate = reservation.getStartDate().minusDays(1);
            LocalDateTime newEndDate = reservation.getEndDate().minusDays(1);
            if(!checkDateIsAcceptable(newStartDate,newEndDate,reservation.getTableId())) throw new RuntimeException("Table is already reserved");
            reservation.setStartDate(newStartDate);
            reservation.setEndDate(newEndDate);
            return this.repository.save(reservation);
        } else {
            throw new NotFoundException("Reservation not found with given id: " + id);
        }
    }

    public List<DashboardAnalyticResponse> calculateAnalyticForRestaurant(@NonNull Long restaurantId){
        final List<Reservation> reservations = this.repository.findByRestaurantIdAndStatusIsNot(restaurantId,Status.CANCELLED);
        if(ObjectUtils.isEmpty(reservations)) return Collections.singletonList(DashboardAnalyticResponse.builder().totalEntities(0).build());
        List<DashboardAnalyticResponse> response = new ArrayList<>();
        response.add(buildForMonth(reservations));
        response.add(buildForDay(reservations));
        response.add(buildForWeek(reservations));

        return response;
    }

    private DashboardAnalyticResponse buildForMonth(final List<Reservation> reservations){

        Map<Integer,Integer> valueMap = reservations.stream().collect(Collectors.groupingBy(Reservation::getMonth,Collectors.collectingAndThen(Collectors.counting(),Long::intValue)));
        return DashboardAnalyticResponse.builder().intervalType("month").valueMap(valueMap).totalEntities(reservations.size()).build();
    }

    private DashboardAnalyticResponse buildForDay(final List<Reservation> reservations){
        Map<Integer,Integer> valueMap = reservations.stream().collect(Collectors.groupingBy(Reservation::getDay,Collectors.collectingAndThen(Collectors.counting(),Long::intValue)));
        return DashboardAnalyticResponse.builder().intervalType("day").valueMap(valueMap).totalEntities(reservations.size()).build();
    }

    private DashboardAnalyticResponse buildForWeek(final List<Reservation> reservations){
        Map<Integer,Integer> valueMap = reservations.stream().collect(Collectors.groupingBy(Reservation::getWeek,Collectors.collectingAndThen(Collectors.counting(),Long::intValue)));
        return DashboardAnalyticResponse.builder().intervalType("week").valueMap(valueMap).totalEntities(reservations.size()).build();
    }

    public void findAndCancelledReservations(){
        LocalDateTime origin = LocalDateTime.now().minusMinutes(10);
        this.repository.cancelReservationIfTimeIsPassed(origin,Status.CANCELLED);
    }

}
