package org.example.hibernate_work.entities;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.hibernate_work.enums.PaymentStatus;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("MOBILE_MONEY")
@RequiredArgsConstructor
@Setter
@Getter
public class MobileMoneyPayment extends Payment {

    private String phoneNumber;
    private String provider;

    public MobileMoneyPayment(String phoneNumber, String provider,
                       BigDecimal amount, String currency, PaymentStatus status,
                       String description
    ){
        super(amount, currency, status, description);
        this.phoneNumber = phoneNumber;
        this.provider = provider;
    }

}
