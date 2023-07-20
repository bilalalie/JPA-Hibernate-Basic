package com.example.jpahibernate;

import com.example.jpahibernate.model.Student;
import com.example.jpahibernate.model.StudentConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.util.List;

@SpringBootApplication
public class JpaHibernateApplication {

    public static void main(String[] args) throws ParseException {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(StudentConfig.class);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        RandomStudentGenerator randomStudentGenerator = new RandomStudentGenerator();
        List <Student> students= RandomStudentGenerator.generateRandomStudents(390);
        transaction.begin();
        for (Student student : students) {
            entityManager.persist(student);
        }
        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();


//        SpringApplication.run(JpaHibernateApplication.class, args);
    }

}
