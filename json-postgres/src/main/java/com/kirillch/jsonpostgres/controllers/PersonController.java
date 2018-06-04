package com.kirillch.jsonpostgres.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kirillch.jsonpostgres.entities.Person;
import com.kirillch.jsonpostgres.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
public class PersonController {

    private final static Logger logger = LoggerFactory.getLogger(PersonController.class);

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping("json")
    public void json() {
        //get json data from file "people.json" in our resources

//        For Windows
//        URL url = this.getClass().getClassLoader().getResource("people.json");
//        File jsonFile = new File(url.getFile());

        File jsonFile = null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:people.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<Person> people = objectMapper.readValue(jsonFile, new TypeReference<List<Person>>() {
            });

            personRepository.saveAll(people);

            logger.info("All records saved.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
