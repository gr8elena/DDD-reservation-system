package com.example.activitiesmanagment.domain.models;

import com.example.sharedkernel.domain.base.DomainObjectId;

public class ActivityId extends DomainObjectId {

    public ActivityId(String id) {
        super(id);
    }

    public static ActivityId of(String id) {
        return new ActivityId(id);
    }

    public static ActivityId randomId() {
        return new ActivityId(DomainObjectId.randomId(ActivityId.class).toString());
    }
}
