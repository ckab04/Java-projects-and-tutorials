package org.example.hibernate_work;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transaction;
import org.example.hibernate_work.config.DatabaseConfig;
import org.example.hibernate_work.entities.Address;
import org.example.hibernate_work.entities.Department;
import org.example.hibernate_work.entities.Employee;
import org.example.hibernate_work.entities.Project;
import org.example.hibernate_work.repository.EmpRepository;
import org.example.hibernate_work.repository.EmployeeRepository;
import org.hibernate.Session;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

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

    public void addMapping(Session session){

        Project p1 = new Project("CONSTRUCTION");
        Project p2 = new Project("ROUTES");
        Project p3 = new Project("ELECTIONS");
        Department d1 = new Department("CIVIL");
        Department d2 = new Department("ARCHITECTURE");
        Department d3 = new Department("CENI");
        //Department d4 = new Department("MARKET EVALUATION");

        d1.addProject(p1);
        d1.addProject(p2);
        d2.addProject(p1);
        d2.addProject(p2);
        d2.addProject(p3);


        Employee emp1 = new Employee("Jane", "July", "janejuly@gmail.com");
        Employee emp2 = new Employee("Harold", "Grealish", "harold@gmail.com");
        Employee emp3 = new Employee("Jack", "Jacobs", "jack@gmail.com");

        emp1.addDepartment(d1);
        emp1.addDepartment(d2);
        emp2.addDepartment(d3);
        emp2.addDepartment(d2);
        emp3.addDepartment(d1);

        emp1.setAddress(new Address("123 Main St", "France"));
        emp2.setAddress(new Address("124 Main St", "France"));
        emp3.setAddress(new Address("128 Main St", "France"));


        session.persist(emp1);
        session.persist(emp2);
        session.persist(emp3);

    }

    public void deleteSomeData(Session session){

        Employee emp = session.find(Employee.class, 203);
        String name = emp.getName();
        List<Department> dpts = emp.getDepartment();
        System.out.println("EMPLOYEE RETRIEVED INFO");
        System.out.println(name);
        dpts.forEach((dp) -> System.out.println(dp.getName()));

        //session.remove(emp);
        System.out.println("REMOVE A SINGLE DEPARTMENT");
        Department dpt = dpts.getFirst();
        dpt.getEmployee().removeDepartment(dpt);

    }



    //@Transactional(readOnly = true)
    public void findAllEmployees(EmpRepository empRepository){


        List<Employee> employees = empRepository.findAllWithDepartments();
        employees.forEach(emp -> {
            System.out.println(emp.getName());
            List<Department> dpts = emp.getDepartment();
            System.out.println("LIST OF ALL THE DEPARTMENTS");
            dpts.forEach((d) -> System.out.println(d.getName()));
        });
    }

    public void saveEmployees(EmpRepository empRepository){
       Employee emp = new Employee("Christian", "Coleman", "cc@gmail.com") ;

       Address address = new Address("123, Church Street", "Mexico");
       emp.setAddress(address);

       Department department1 = new Department("CHOIR");
       Department department2 = new Department("POLE SOCIAL");

       Project pj1 = new Project("Build a house");
        Project pj2 = new Project("Find a church");
        Project pj3 = new Project("Get a property");
        Project pj4 = new Project("Buy a laptop");

        department1.addProject(pj1);
        department1.addProject(pj2);
        department2.addProject(pj3);
        department2.addProject(pj4);

        emp.addDepartment(department1);
        emp.addDepartment(department2);
        empRepository.save(emp);

    }


    @Bean
    public CommandLineRunner demo(EmployeeRepository repo, EmpRepository empRepository) {

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

            //detachEntity(session);
            //addMapping(session);
            //deleteSomeData(session);
            //findAllEmployees(empRepository);
            saveEmployees(empRepository);

            tx.commit();
            em.close();

        };

    }
}
