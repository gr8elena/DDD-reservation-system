package com.example.reservationsmanagment.service.impl;

import com.example.reservationsmanagment.domain.exception.ReservationItemNotFoundException;
import com.example.reservationsmanagment.domain.exception.ReservationNotFoundException;
import com.example.reservationsmanagment.domain.model.Reservation;
import com.example.reservationsmanagment.domain.model.ReservationId;
import com.example.reservationsmanagment.domain.repository.ReservationRepository;
import com.example.reservationsmanagment.service.ReservationService;
import com.example.reservationsmanagment.service.forms.ReservationForm;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import jakarta.validation.Validator;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    private final Validator validator;


    @Override
    public ReservationId placeReservation(ReservationForm reservationForm) throws ConstraintViolationException {
        Objects.requireNonNull(reservationForm, "reservation must not be null");
        var violations = validator.validate(reservationForm);

        if(!violations.isEmpty())
        {
            throw  new IllegalArgumentException("Invalid reservation data");
        }

        var newReservation = new Reservation(reservationForm.getCurrency(), reservationForm.getNumberOfPersons(), reservationForm.getStartDate(), reservationForm.getEndDate(), reservationForm.getDuration(), reservationForm.getActivityId(), reservationForm.getUserId());

        return newReservation.getId();
    }

    @Override
    public Optional<Reservation> findById(ReservationId reservationId) {
        return (Optional<Reservation>) reservationRepository.findById(reservationId).orElseThrow();
    }


    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }


    public ReservationId addReservation(@NonNull ReservationForm reservation) throws ReservationItemNotFoundException {
        var violations = validator.validate(reservation);
        if (!violations.isEmpty()) {
            throw new IllegalArgumentException("Invalid user data");
        }

        var r = new Reservation(reservation.getCurrency(), reservation.getNumberOfPersons(), reservation.getStartDate(), reservation.getEndDate(), reservation.getDuration(), reservation.getActivityId(), reservation.getUserId());

        return reservationRepository.saveAndFlush(r).getId();

    }

    @Override
    public void deleteReservation(ReservationId reservationId) throws ReservationItemNotFoundException, ReservationNotFoundException {
        reservationRepository.deleteById(reservationId);
    }

    @Override
    public Reservation updateReservation(ReservationId reservationId, ReservationForm reservationForm) {
        var reservation = findById(reservationId).orElseThrow();

        reservation.updateReservation(reservationForm.getCurrency(), reservationForm.getNumberOfPersons(), reservationForm.getStartDate(), reservationForm.getEndDate(), reservationForm.getDuration(), reservationForm.getActivityId(), reservationForm.getUserId());
        return  reservationRepository.saveAndFlush(reservation);
    }
}