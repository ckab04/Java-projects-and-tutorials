package org.example.hibernate_work.entities;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.hibernate_work.enums.PaymentStatus;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("BANK_TRANSFER")
@RequiredArgsConstructor
@Setter
@Getter
public class BankTransferPayment extends Payment {

    private String iban;
    private String bankName;

    public BankTransferPayment(String iban, String bankName,
                              BigDecimal amount, String currency, PaymentStatus status,
                              String description
    ){
        super(amount, currency, status, description);
        this.iban = iban;
        this.bankName = bankName;
    }

}
