package ru.kirillch.springdata;

import org.hibernate.LazyInitializationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kirillch.springdata.entity.Address;
import ru.kirillch.springdata.entity.Person;
import ru.kirillch.springdata.repository.AddressRepository;
import ru.kirillch.springdata.repository.PersonRepository;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationsTest {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AddressRepository addressRepository;

    @Test(expected = LazyInitializationException.class)
    public void lazyLoadingException() throws Exception {
        List<Person> anna = personRepository.findByFirstName("Anna");
        //session closed

        System.out.println(anna.get(0).getPhones());
    }

    @Test
    @Transactional
    public void lazyLoadingTransaction() throws Exception {
        List<Person> anna = personRepository.findByFirstName("Anna");

        System.out.println(anna.get(0).getPhones());
    }

    @Test
    public void deleteAddress() throws Exception {
        List<Address> cities = addressRepository.findByCity("Samara");
        assertThat(cities).hasSize(1);

        addressRepository.delete(cities.get(0));

        List<Person> people = personRepository.findAll();
        assertThat(people).hasSize(2);

    }

    @Test
    public void deletePerson() throws Exception {

        List<Person> people = personRepository.findByFirstName("Olesya");

        personRepository.delete(people.get(0));
        List<Address> addresses = addressRepository.findAll();
        assertThat(addresses).hasSize(2);
    }

    @Test
    public void fetchTypeLoading() throws Exception {
        List<Person> people = personRepository.findAll();
    }


}






