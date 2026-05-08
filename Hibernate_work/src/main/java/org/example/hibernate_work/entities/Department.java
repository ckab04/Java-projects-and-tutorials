package org.example.hibernate_work.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name="department_project",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn( name = "project_id")
    )
    private List<Project> projects = new ArrayList<>();


    public Department(String name){
        this.name = name;
        this.projects = new ArrayList<>();
    }



    // convenience method

    public void addProject(Project project){
        projects.add(project);
        project.getDepartments().add(this);
    }

    public void removeProject(Project project){
        projects.remove(project);
        project.getDepartments().remove(this);
    }






}
