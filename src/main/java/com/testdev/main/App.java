package com.testdev.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.testdev.domain.Person;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration
                .buildSessionFactory(serviceRegistry);
        
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Person aPerson = (Person) session.load(Person.class, 1L);
        System.out.println(aPerson);

        session.getTransaction().commit();
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }
}
