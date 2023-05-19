package com.example.activitiesmanagment.services.forms;

import jakarta.validation.constraints.NotNull;
import com.example.sharedkernel.domain.address.Address;
import com.example.sharedkernel.domain.financial.Money;
import lombok.Data;
import lombok.NonNull;

@Data
public class ActivityForm {

    @NotNull
    private String activityType;

    @NotNull
    private Address address;

    @NotNull
    private int numberOfPeople;

    @NotNull
    private Money price;
}
