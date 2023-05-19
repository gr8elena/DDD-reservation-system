package com.example.reservationsmanagment.domain.valueobjects;

import com.example.sharedkernel.domain.address.Address;
import com.example.sharedkernel.domain.base.ValueObject;
import com.example.sharedkernel.domain.financial.Money;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class Activity implements ValueObject {

    private final Address address;

    private final String activityType;

    private final int numberOfInterestedGuests;

    private final Money price;

    @JsonCreator
    public Activity(Address address, String activityType, int numberOfInterestedGuests, Money price) {
        this.address = address;
        this.activityType = activityType;
        this.numberOfInterestedGuests = numberOfInterestedGuests;
        this.price = price;
    }
}
