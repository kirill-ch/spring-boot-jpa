package ru.kirillch.springdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.kirillch.springdata.repository.PersonRepository;

@SpringBootApplication
public class SpringdataJPAApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringdataJPAApplication.class, args);
    }

    @Autowired
    PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {

//        Person anna = new Person("Anna", "Andreeva", "Samara");
//        Person olesya = new Person("Olesya", "Andreeva", "Moscow");
//        Person alex = new Person("Alex", "Andreev", "Omsk");
//
//        List<Person> people = Arrays.asList(anna, olesya, alex);
//
//        personRepository.saveAll(people);
//
//        System.out.println("<<<<<<<<" + personRepository.findAll());
    }
}
