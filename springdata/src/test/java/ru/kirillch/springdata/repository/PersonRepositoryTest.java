package ru.kirillch.springdata.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kirillch.springdata.entity.Person;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @Test
    public void findByFirstName() throws Exception {

        List<Person> people = personRepository.findByFirstName("Anna");

        assertThat(people).hasSize(1);
        assertThat(people.get(0).getLastName()).isEqualTo("Andreeva");

    }

    @Test
    public void findAllOrderedByFirstName() throws Exception {
        List<Person> people = personRepository.findAllOrderedByFirstName();

        assertThat(people).hasSize(3);
        assertThat(people.get(2).getFirstName()).isEqualTo("Olesya");
        assertThat(people.get(1).getFirstName()).isEqualTo("Anna");

    }
}