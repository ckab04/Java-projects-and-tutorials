package org.example.hibernate_work.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;
import java.util.function.Consumer;
import java.util.function.Function;

@Configuration
public class DatabaseConfig {

    private final EntityManagerFactory entityManagerFactory;

    DatabaseConfig(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory = entityManagerFactory;
    }

    public EntityManager getEntityManager(){
        return this.entityManagerFactory.createEntityManager();
    }


    // for void operations
    public void executeInTransaction(Consumer<EntityManager> action){
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        try{
            action.accept(entityManager);
            entityManager.getTransaction().commit();
        }catch(RuntimeException e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw e;
        }finally{
            entityManager.close();
        }
    }

    public <T> T executeInTransaction(Function<EntityManager, T> action){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try{
            T result = action.apply(em);
            em.getTransaction().commit();
            return result;
        }catch (RuntimeException e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }

            throw e;
        }finally{
            em.close();
        }
    }

}
