package com.example.activitiesmanagment.domain.exception;

public class ActivityNotFoundException extends RuntimeException{
    public ActivityNotFoundException(String message) {
        super(message);
    }
}
