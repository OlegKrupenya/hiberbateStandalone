package com.testdev.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.testdev.domain.Event;
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
        try {
        session.beginTransaction();

//        Person aPerson = (Person) session
//                .createQuery("select p from Person p left join fetch p.events where p.id = :pid")
//                .setParameter("pid", 1L)
//                .uniqueResult();
        Person aPerson  = (Person) session.load(Person.class, 7L);
//        Person aPerson  = new Person();
//        aPerson.setAge(70);
//        aPerson.setFirstname("70");
//        aPerson.setLastname("70");
//        aPerson.setVersion(1);
        System.out.println(aPerson);
//        Event event = new Event();
//        event.setTitle("New 9");
//        session.save(event);
        
        /*aPerson.getEvents().add(event);

        */
        aPerson.setFirstname("updated name 2");
        session.update(aPerson);
       
        session.getTransaction().commit();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
    }
}
