package com.example.reservationsmanagment.service;

import com.example.reservationsmanagment.domain.exception.ReservationItemNotFoundException;
import com.example.reservationsmanagment.domain.exception.ReservationNotFoundException;
import com.example.reservationsmanagment.domain.model.Reservation;
import com.example.reservationsmanagment.domain.model.ReservationId;
import com.example.reservationsmanagment.service.forms.ReservationForm;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

public interface ReservationService {

    ReservationId placeReservation(ReservationForm reservationForm) throws ConstraintViolationException;

    Optional<Reservation> findById(ReservationId reservationId);

    List<Reservation> findAll();

    ReservationId addReservation(ReservationForm reservationForm) throws ReservationItemNotFoundException;

    void deleteReservation(ReservationId reservationId) throws ReservationItemNotFoundException, ReservationNotFoundException;

    Reservation updateReservation(ReservationId reservationId, ReservationForm reservationForm);

}
