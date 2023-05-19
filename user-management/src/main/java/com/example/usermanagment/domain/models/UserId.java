package com.example.usermanagment.domain.models;

import com.example.sharedkernel.domain.base.DomainObjectId;

public class UserId extends DomainObjectId {

    public UserId() {
        super(UserId.randomId(UserId.class).getId());
    }

    public UserId(String uuid) {
        super(uuid);
    }
}
