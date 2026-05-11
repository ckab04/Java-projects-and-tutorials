package org.example.hibernate_work.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "employee_info", schema = "all_employees")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "department")
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

    @Embedded
    private Address address;

    //@Column(name="department")
    //private String department;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "employee",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<Department> department;

//    @OneToMany(mappedBy = "employee",
//            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
//            fetch = FetchType.LAZY,
//            orphanRemoval = true
//    )
//    private Set<Payment> payment = new HashSet<>();



    @PrePersist
    protected void onCreate(){
        createdAt= LocalDateTime.now();
    }

    public Employee(String name, String lastname, String email) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.department = new ArrayList<>();
        // createdAt will be set by @PrePersist
    }

    public void addDepartment(Department dpt){
        this.department.add(dpt);
        dpt.setEmployee(this);
    }

    public void removeDepartment(Department dpt){
        this.department.remove(dpt);
        dpt.setEmployee(null);
    }

}
