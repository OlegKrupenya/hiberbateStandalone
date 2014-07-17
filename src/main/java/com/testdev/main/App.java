package com.testdev.main;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
        session.beginTransaction();
        
        Map map = new HashMap<>();
        map.put("age", 20);
        map.put("firstname", "firstname");
        map.put("lastname", "lastname");
        
        session.save("Person", map);

        Map resMap = (Map) session.load("Person", 1L);
        System.out.println(resMap);
//        Person aPerson = (Person) session
//                .createQuery("select p from Person p left join fetch p.events where p.id = :pid")
//                .setParameter("pid", 1L)
//                .uniqueResult();
       // System.out.println(aPerson.getFirstname() + " " + aPerson.getLastname());
        
        
//        Person aPerson  = (Person) session.load(Person.class, 1L);
//        Event event = new Event();
//        event.setTitle("New 9");
//        event.setDate(new Date());
//        
//        aPerson.getEvents().add(event);
//
//        session.save(event);
        
       
        session.getTransaction().commit();
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }
}
