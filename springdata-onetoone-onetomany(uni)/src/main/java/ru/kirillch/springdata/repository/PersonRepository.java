package ru.kirillch.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.kirillch.springdata.entity.Person;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByFirstName(String firstName);

    @Query("select p from Person p order by firstName")
    List<Person> findAllOrderedByFirstName();

}
