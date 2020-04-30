package com.example.soaptask.repository;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import spring.soap.Gender;
import spring.soap.Person;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonRepository {
    private static final Logger log = Logger.getLogger(PersonRepository.class.getName());
    private static List<Person> people = new ArrayList<>();

    @PostConstruct
    public void initData(){
        log.info("init data for application");
        Person p1 = new Person();
        p1.setName("Petr");
        p1.setAge(20);
        p1.setGender(Gender.MALE);
        people.add(p1);

        Person p2 = new Person();
        p2.setName("Ivan");
        p2.setAge(23);
        p2.setGender(Gender.MALE);
        people.add(p2);

        Person p3 = new Person();
        p3.setName("Kate");
        p3.setAge(20);
        p3.setGender(Gender.FEMALE);
        people.add(p3);
    }

    public Person findPersonByName(String name){
        Person targetPerson = null;
        for (Person p: people){
            if (p.getName().equals(name)) {
                log.info("target person found");
                targetPerson = p;
            }
        }
        return targetPerson;
    }
}
