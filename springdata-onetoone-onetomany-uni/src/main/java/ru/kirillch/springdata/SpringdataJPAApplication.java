package ru.kirillch.springdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.kirillch.springdata.entity.Address;
import ru.kirillch.springdata.entity.Passport;
import ru.kirillch.springdata.entity.Person;
import ru.kirillch.springdata.entity.Phone;
import ru.kirillch.springdata.repository.AddressRepository;
import ru.kirillch.springdata.repository.PersonRepository;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringdataJPAApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringdataJPAApplication.class, args);
    }

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AddressRepository addressRepository;

    @Override
    public void run(String... args) throws Exception {

        Person anna = new Person("Anna", "Andreeva");
        Person olesya = new Person("Olesya", "Andreeva");

        //passports
        Passport passportAnna = new Passport("A1111111");
        Passport passportOlesya = new Passport("M3333333");

        //phones
        Phone phone1 = new Phone("123-123-123");
        Phone phone2 = new Phone("222-222-222");
        Phone phone3 = new Phone("333-333-333");
        Phone phone4 = new Phone("444-444-444");

        //addresses
        Address address1 = new Address("Samara");
        Address address2 = new Address("Omsk");
        Address address3 = new Address("Novosibirsk");
        Address address4 = new Address("Moscow");

        anna.setPassport(passportAnna);
        anna.setPhones(Arrays.asList(phone1, phone2));
        anna.setAddresses(Arrays.asList(address1, address2));

        olesya.setPassport(passportOlesya);
        olesya.setPhones(Arrays.asList(phone3, phone4));
        olesya.setAddresses(Arrays.asList(address3, address4));

        List<Person> people = Arrays.asList(anna, olesya);

        personRepository.saveAll(people);

        System.out.println("<<<<<< Initialized >>>>>>>");

    }
}
