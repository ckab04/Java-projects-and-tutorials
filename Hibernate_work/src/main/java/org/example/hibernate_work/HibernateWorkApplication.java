package org.example.hibernate_work;

import org.example.hibernate_work.entities.Employee;
import org.example.hibernate_work.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class HibernateWorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateWorkApplication.class, args);

    }

    @Bean
   public CommandLineRunner demo(EmployeeRepository repo){

        return (args) -> {
            repo.createEmployee(
                    new Employee("Furaha", "Fatuma", "ff@gmail.com", "IT"));

            repo.createEmployee(
                    new Employee("Elisa", "Jasmine", "elisa@gmail.com", "IT"));





        };
    }

}
