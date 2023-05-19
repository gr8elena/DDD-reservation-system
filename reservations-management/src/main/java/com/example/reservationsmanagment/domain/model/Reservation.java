package com.example.reservationsmanagment.domain.model;


import com.example.reservationsmanagment.domain.valueobjects.ActivityId;
import com.example.reservationsmanagment.domain.valueobjects.UserId;
import com.example.reservationsmanagment.service.forms.ReservationForm;
import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.financial.Currency;
import com.example.sharedkernel.domain.financial.Money;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Date;

@Entity
@Table(name = "reservation_activity")
@Getter
public class Reservation extends AbstractEntity<ReservationId> {

    private Money price;

    private int numberOfPersons;

    private Date startDate;

    private Date endDate;

    private int duration;

    @Column(insertable=false, updatable=false)
    @AttributeOverride(name = "id", column = @Column(name = "activity_id", nullable = false))
    private ActivityId activityId;

    @Column(insertable=false, updatable=false)
    @AttributeOverride(name = "id", column = @Column(name = "user_id", nullable = false))
    private UserId userId;

    public Reservation(Currency currency, ReservationForm reservationForm) {
        super(ReservationId.randomId(ReservationId.class));
    }
    public Reservation(){
        super(ReservationId.randomId(ReservationId.class));
    }

public Reservation(Money price, int numberOfPersons, Date startDate, Date endDate, int duration, ActivityId activityId, UserId userId) {
        super(ReservationId.randomId(ReservationId.class));
        this.price = price;
        this.numberOfPersons = numberOfPersons;
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = duration;
        this.activityId = activityId;
        this.userId = userId;
    }

    public void updateReservation(Money price, int numberOfPersons, Date startDate, Date endDate, int duration, ActivityId activityId, UserId userId){
        this.price = price;
        this.numberOfPersons = numberOfPersons;
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = duration;
        this.activityId = activityId;
        this.userId = userId;
    }


    public double total(){
        return numberOfPersons* price.getAmount();
    }
}
