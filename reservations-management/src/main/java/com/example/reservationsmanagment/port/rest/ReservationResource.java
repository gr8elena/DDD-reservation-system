package com.example.reservationsmanagment.port.rest;

import com.example.reservationsmanagment.domain.model.Reservation;
import com.example.reservationsmanagment.domain.model.ReservationId;
import com.example.reservationsmanagment.service.ReservationService;
import com.example.reservationsmanagment.service.forms.ReservationForm;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
@AllArgsConstructor
public class ReservationResource {
    private final ReservationService reservationService;

    @GetMapping
    public List<Reservation> listAll() {
        return reservationService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> findById(@PathVariable("id") ReservationId id) {
        return reservationService.findById(id);
    }

    @PostMapping("/create")
    public void createUser(@RequestBody ReservationForm reservationForm, HttpServletResponse response) throws IOException, IOException {
        reservationService.addReservation(reservationForm);
        response.sendRedirect("/api/reservations");
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") ReservationId reservationId, @RequestBody ReservationForm reservation, HttpServletResponse response) throws IOException {
        reservationService.updateReservation(reservationId, reservation);
        response.sendRedirect("/api/reservations");
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable("id") ReservationId reservationId, HttpServletResponse response) throws IOException {
        reservationService.deleteReservation(reservationId);
        response.sendRedirect("/api/reservations");
    }
}