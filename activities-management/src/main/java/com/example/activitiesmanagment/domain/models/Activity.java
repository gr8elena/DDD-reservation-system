package com.example.activitiesmanagment.domain.models;

import com.example.sharedkernel.domain.address.Address;
import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.financial.Money;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "activities")
public class Activity extends AbstractEntity<ActivityId> {

    private Address address;

    private String activityType;

    private int numberOfInterestedGuests;

    private Money price;


    public Activity() {
        super(ActivityId.randomId(ActivityId.class));
    }

    public Activity(Address address, String activityType, int numberOfInterestedGuests, Money price) {
        super(ActivityId.randomId(ActivityId.class));
        this.address = address;
        this.activityType = activityType;
        this.numberOfInterestedGuests = numberOfInterestedGuests;
        this.price = price;
    }

    public void updateActivity(Address address, String activityType, int numberOfInterestedGuests, Money price) {
        this.address = address;
        this.activityType = activityType;
        this.numberOfInterestedGuests = numberOfInterestedGuests;
        this.price = price;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Activity activity = (Activity) o;
        return numberOfInterestedGuests == activity.numberOfInterestedGuests && address.equals(activity.address) && activityType.equals(activity.activityType) && price.equals(activity.price);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
