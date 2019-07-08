package ru.kirillch.springdata.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kirillch.springdata.entity.Person;

public class HibernateService {

    public void doSomething(){

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();

        int personId = 1;
        Person person = session.get(Person.class, personId);

        //...
        // person.getPhones().size()

        session.getTransaction().commit();
        session.close();

        //LazyInitializationException
        System.out.println(person.getPhones());

    }

}




