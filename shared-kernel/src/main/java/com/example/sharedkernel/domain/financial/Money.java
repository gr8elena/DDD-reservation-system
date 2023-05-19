package com.example.sharedkernel.domain.financial;

import com.example.sharedkernel.domain.base.ValueObject;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NonNull;

@Embeddable
@Getter
public class Money implements ValueObject {

        @Enumerated(value = EnumType.STRING)
        private final Currency currency;

        private final double amount;

        public Money(int i){
            this.currency = null;
            this.amount = 0;
        }

    public Money(@NonNull Currency currency, @NonNull double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    //ni kreira nova instanca od klasata money
    public static Money valueOf(Currency currency, double amount) {
        return new Money(currency, amount);
    }

    public Money add(Money money){
            //ako ne se od ista valuta
            if(!currency.equals(money.currency)){
                throw new IllegalArgumentException("Cannot add two money objects with different currencies");
            }
            return new Money(currency, amount + money.amount);
    }

    public Money subtract(Money money){
            //ako ne se od ista valuta
            if(!currency.equals(money.currency)){
                throw new IllegalArgumentException("Cannot subtract two money objects with different currencies");
            }
            return new Money(currency, amount - money.amount);
    }

    public Money multiply(int m){
            return new Money(currency, amount * m);
    }

}
