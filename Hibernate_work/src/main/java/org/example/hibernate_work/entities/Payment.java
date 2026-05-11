package org.example.hibernate_work.entities;


import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.hibernate_work.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "payment_type", discriminatorType = DiscriminatorType.STRING, length = 20)
//@NoArgsConstructor
@Table(name = "payment_v2")
@RequiredArgsConstructor
public abstract class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private BigDecimal amount;

    private String currency;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
    private String description ;

    protected Payment(BigDecimal amount, String currency, PaymentStatus status,
                      String description
                      ){
        this.amount = amount;
        this.currency = currency;
        this.status = PaymentStatus.PENDING;
        this.description = description;
    }


//    @ManyToOne
//    @JoinColumn(name = "employee_id")
//    Employee employee;

}
