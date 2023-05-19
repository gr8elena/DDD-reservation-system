package com.example.usermanagment.domain.models;

import com.example.sharedkernel.domain.base.AbstractEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;

import java.sql.Time;

@Entity
@Getter
public class LogIn extends AbstractEntity<LogInId> {

    private Time loginTime;

    @AttributeOverride(name="id", column=@Column(name="user_id", nullable=false))
    private UserId userId;

    public LogIn(LogInId id, Time loginTime, UserId userId) {
        super(id);
        this.loginTime = loginTime;
        this.userId = userId;
    }

    public LogIn() {
        super(LogInId.randomId(LogInId.class));
    }

    public LogIn(Time loginTime, UserId userId) {
        super(LogInId.randomId(LogInId.class));
        this.loginTime = loginTime;
        this.userId = userId;
    }



}
