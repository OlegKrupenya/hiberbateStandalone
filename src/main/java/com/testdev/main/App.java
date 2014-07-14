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

        Person aPerson = (Person) session
                .createQuery("select p from Person p left join fetch p.events where p.id = :pid")
                .setParameter("pid", 1L)
                .uniqueResult();
        System.out.println(aPerson);

        session.getTransaction().commit();
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }
}
