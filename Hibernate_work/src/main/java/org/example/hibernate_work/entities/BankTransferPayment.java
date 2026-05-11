package org.example.hibernate_work.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.hibernate_work.enums.PaymentStatus;

import java.math.BigDecimal;

@Entity
//@DiscriminatorValue("BANK_TRANSFER")
@RequiredArgsConstructor
@Setter
@Getter
@Table(name = "bank_transfer_payment_v2")
@PrimaryKeyJoinColumn(name = "bank_transfer_id")
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
