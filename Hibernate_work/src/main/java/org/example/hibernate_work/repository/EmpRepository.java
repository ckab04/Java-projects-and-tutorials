package org.example.hibernate_work.repository;

import org.example.hibernate_work.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface EmpRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e JOIN FETCH e.department")
    List<Employee> findAllWithDepartments();


    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.email = :email WHERE e.id = :id")
    int updateEmailById(@Param("id") Long id, @Param("email") String email);

    @Modifying
    @Transactional
    @Query("DELETE FROM Employee e WHERE e.lastname = :lastname")
    int deleteByLastname(@Param("lastname") String lastname);


}
