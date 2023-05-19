package com.example.usermanagment.domain.models;

import com.example.sharedkernel.domain.base.DomainObjectId;

public class LogInId extends DomainObjectId {

    public LogInId() {
        super(LogInId.randomId(LogInId.class).getId());
    }

    public LogInId(String uuid) {
        super(uuid);
    }

}
