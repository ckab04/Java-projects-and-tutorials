package org.example.hibernate_work.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.example.hibernate_work.config.DatabaseConfig;
import org.example.hibernate_work.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public class EmployeeRepository {

    private final EntityManager entityManager;

    DatabaseConfig dbConfig;

    EmployeeRepository(EntityManager entityManager, DatabaseConfig dbConfig){
        this.entityManager = entityManager;
        this.dbConfig = dbConfig;
    }





    public void createEmployee(Employee emp){
        dbConfig.executeInTransaction( em -> {

            em.persist(emp);
        });
    }

    public Employee getEmployeeByName(String name){

        EntityManager entityManager = this.dbConfig.getEntityManager();

        String jpql = "SELECT e from Employee e where e.name = :name";
        try{
            return entityManager.createQuery(jpql, Employee.class)
                    .setParameter("name", name)
                    .getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }




    public Optional<Employee> findEmployeeByName(String name){
        return dbConfig.executeInTransaction(em -> {
            String jpql = "SELECT e from Employee e where e.name = :name";
            try{
                return Optional.of( em.createQuery(jpql, Employee.class)
                        .setParameter("name", name)
                        .getSingleResult());
            }catch(NoResultException e){
                return Optional.empty();
            }
        });
    }


}
