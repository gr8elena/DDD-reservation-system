package com.example.reservationsmanagment.domain.model;

import com.example.sharedkernel.domain.base.DomainObjectId;

public class ReservationId extends DomainObjectId {

        private ReservationId() {
            super(ReservationId.randomId(ReservationId.class).getId());
        }

        public ReservationId(String uuid) {
            super(uuid);
        }

        public static ReservationId of(String uuid) {
            ReservationId p = new ReservationId(uuid);
            return p;
        }
}
