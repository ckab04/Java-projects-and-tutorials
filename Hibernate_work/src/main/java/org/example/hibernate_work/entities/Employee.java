package org.example.hibernate_work.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "employee_info", schema = "all_employees")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="lastname")
    private String lastname;

    @Column(name="email")
    private String email;

    @Column(name="department")
    private String department;

    private LocalDateTime createdAt;



    @PrePersist
    protected void onCreate(){
        createdAt= LocalDateTime.now();
    }

    public Employee(String name, String lastname, String email, String department) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.department = department;
        // createdAt will be set by @PrePersist
    }

}
