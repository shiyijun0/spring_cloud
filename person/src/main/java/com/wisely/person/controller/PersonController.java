package com.wisely.person.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import com.wisely.person.dao.PersonRepository;
import com.wisely.person.domain.Person;

@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/sd")
    public String sd(){
        return "shiyijun";
    }

    @RequestMapping("/syj")
    public String syj(@RequestParam String name){
        return "shiyi"+name;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public List<Person> savePerson(@RequestBody Person  personName) {
    	//Person p = new Person(personName);
    	personRepository.save(personName);
    	List<Person> people = personRepository.findAll(new PageRequest(0, 10)).getContent();
        return people;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public List<Person> insert(@RequestParam  String  personName) {
        Person p = new Person(personName);
        personRepository.save(p);
        List<Person> people = personRepository.findAll(new PageRequest(0, 10)).getContent();
        return people;
    }



}
