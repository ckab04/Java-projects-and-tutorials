package org.example.hibernate_work.entities;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.hibernate_work.enums.PaymentStatus;

import java.math.BigDecimal;

@Entity
//@DiscriminatorValue("CREDIT_CARD")
//@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@Table(name = "card_payment_v2")
@PrimaryKeyJoinColumn(name = "card_id")
public class CardPayment extends Payment{
    private String cardNumber;
    private String expiryDate;


   public CardPayment(String cardNumber, String expiryDate,
                      BigDecimal amount, String currency, PaymentStatus status,
                      String description
                      ){
       super(amount, currency, status, description);
       this.cardNumber = cardNumber;
       this.expiryDate = expiryDate;
   }
}
