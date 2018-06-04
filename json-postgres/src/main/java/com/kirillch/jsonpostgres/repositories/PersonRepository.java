package com.kirillch.jsonpostgres.repositories;

import com.kirillch.jsonpostgres.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
