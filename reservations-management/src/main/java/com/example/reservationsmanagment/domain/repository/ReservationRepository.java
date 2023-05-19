package com.example.reservationsmanagment.domain.repository;

import com.example.reservationsmanagment.domain.model.Reservation;
import com.example.sharedkernel.domain.valueobjects.ReservationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, ReservationId> {

    Optional<Object> findById(com.example.reservationsmanagment.domain.model.ReservationId reservationId);

    void deleteById(com.example.reservationsmanagment.domain.model.ReservationId reservationId);
}
