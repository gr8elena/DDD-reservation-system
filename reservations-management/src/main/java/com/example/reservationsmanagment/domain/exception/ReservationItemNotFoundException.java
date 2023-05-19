package com.example.reservationsmanagment.domain.exception;

public class ReservationItemNotFoundException extends RuntimeException{
    public ReservationItemNotFoundException(String message) {
        super(message);
    }
}
