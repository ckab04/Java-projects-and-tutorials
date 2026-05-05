package org.example.hibernate_work;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transaction;
import org.example.hibernate_work.config.DatabaseConfig;
import org.example.hibernate_work.entities.Employee;
import org.example.hibernate_work.repository.EmployeeRepository;
import org.hibernate.Session;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class HibernateWorkApplication {

    private final DatabaseConfig db;

    HibernateWorkApplication(DatabaseConfig db) {
        this.db = db;
    }

    public static void main(String[] args) {
        SpringApplication.run(HibernateWorkApplication.class, args);

    }

    private void dirtyChecking(Session session){
        //Employee emp = em.getReference(Employee.class, 2L);

        // Dirty checking
//            Employee emp = session.getReference(Employee.class, 2L);
//            System.out.println("BEFORE MODIFICATION ");
//            System.out.println(emp.getName() + " " + emp.getEmail());
//
//
//            emp.setName("Josephine Tudilu");
//            emp.setEmail("josephine@gmail.com");
        // end dirty checking

        // First, let's see what's ACTUALLY in the database
        Tuple beforeAnyChanges = session
                .createNativeQuery("SELECT * FROM all_employees.employee_info WHERE id = 1", Tuple.class)
                .getSingleResult();

        System.out.println("=== DATABASE VALUES BEFORE ANY CHANGES ===");
        System.out.println("DB Name: " + beforeAnyChanges.get("name"));
        System.out.println("DB Email: " + beforeAnyChanges.get("email"));
        String originalDbName = (String) beforeAnyChanges.get("name");
        String originalDbEmail = (String) beforeAnyChanges.get("email");


        // FLUSH MODES
        Employee emp1 = session.getReference(Employee.class, 1L);
        emp1.setEmail("jeanson@gmail.com");
        emp1.setName("JEANSON");
        System.out.println("Entity modified - no flush yet");
        System.out.println(emp1.getName() + " " + emp1.getEmail());


        // USING JPQL
        List<Employee> employees = session
                .createQuery("select e from Employee e", Employee.class)
                .getResultList();

        System.out.println("Result before flushing the data USING JPQL");
        employees.forEach(System.out::println);

        System.out.println("Result before flushing the data USING NATIVE QUERY");

        System.out.println("\n=== TUPLE RESULT (READS FROM DATABASE) ===");
        Tuple viaNative = session
                .createNativeQuery("SELECT * FROM all_employees.employee_info WHERE id = 1", Tuple.class)
                .getSingleResult();

        System.out.println(viaNative.get("name") + " " + viaNative.get("email"));
        System.out.println("Explicit flush called");

        session.flush();


        System.out.println("BEFORE COMMIT : " + emp1.getName() + " " + emp1.getEmail());
        System.out.println("4. Transaction will commit - flush happens here");
    }


    private void detachEntity(Session session){
        Employee emp1 = session.getReference(Employee.class, 1L);
        System.out.println("1. Entity loaded (MANAGED)");
        System.out.println("   Name: " + emp1.getName());
        System.out.println("   Email: " + emp1.getEmail());
        System.out.println("   Is managed? " + session.contains(emp1));

        // STEP 2: DETACH the entity
        session.detach(emp1);
        System.out.println("\n2. Entity DETACHED from persistence context");
        System.out.println("   Is managed? " + session.contains(emp1)); // false

        // STEP 3: Modify while detached (NO automatic DB update)
        emp1.setName("MODIFIED WHILE DETACHED");
        emp1.setEmail("detached@example.com");
        System.out.println("\n3. Entity MODIFIED while detached");
        System.out.println("   New Name: " + emp1.getName());
        System.out.println("   New Email: " + emp1.getEmail());
        System.out.println("   (No UPDATE sent to database yet)");

        // STEP 4: MERGE back to persistence context
        Employee merged = session.merge(emp1);
        System.out.println("\n4. Entity MERGED back to persistence context");
        System.out.println("   Merged instance name: " + merged.getName());
        System.out.println("   Original instance name: " + emp1.getName());
        System.out.println("   Same object? " + (emp1 == merged)); // false
        System.out.println("   Is merged managed? " + session.contains(merged)); // true

        // STEP 5: Changes are now pending flush
        System.out.println("\n5. Changes will be flushed at transaction commit");
        System.out.println("   (UPDATE SQL will be executed automatically)");

    }



    @Bean
    public CommandLineRunner demo(EmployeeRepository repo) {

        return (args) -> {
//            repo.createEmployee(
//                    new Employee("Furaha", "Fatuma", "ff@gmail.com", "IT"));
//
//            repo.createEmployee(
//                    new Employee("Elisa", "Jasmine", "elisa@gmail.com", "IT"));


            EntityManager em = db.getEntityManager();
            Session session = em.unwrap(Session.class);
            EntityTransaction tx = session.beginTransaction();
            //tx.begin();

            detachEntity(session);

            tx.commit();
            em.close();

        };

    }
}
