package com.example.reservationsmanagment.service.forms;

import com.example.reservationsmanagment.domain.valueobjects.ActivityId;
import com.example.reservationsmanagment.domain.valueobjects.UserId;
import com.example.sharedkernel.domain.financial.Currency;
import com.example.sharedkernel.domain.financial.Money;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.sql.Date;


@Getter
@Data
public class ReservationForm {

    @NotNull
    private Money currency;

    @NotNull
    private int numberOfPersons;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    @NotNull
    private int duration;

    @NotNull
    private UserId userId;

    @NotNull
    private ActivityId activityId;

}
