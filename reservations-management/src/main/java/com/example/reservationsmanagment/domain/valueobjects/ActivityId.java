package com.example.reservationsmanagment.domain.valueobjects;

import com.example.sharedkernel.domain.base.DomainObjectId;
import jakarta.persistence.Embeddable;

@Embeddable
public class ActivityId  extends DomainObjectId {


    public ActivityId(String uuid) {
        super(uuid);
    }

    public ActivityId() {
        super(DomainObjectId.randomId(ActivityId.class).getId());

    }
}
