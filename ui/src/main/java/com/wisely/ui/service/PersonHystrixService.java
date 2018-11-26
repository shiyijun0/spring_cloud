package com.wisely.ui.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wisely.ui.domain.Person;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonHystrixService {

	@Autowired
	PersonService personService; 

	@HystrixCommand(fallbackMethod = "fallbackSave") //1
	public List<Person> save(Person name) {
		return personService.save(name);
	}
	
	public List<Person> fallbackSave(Person name){
		List<Person> list = new ArrayList<>();
		Person p = new Person(name.getName()+"没有保存成功，Person Service 故障");
		list.add(p);
		return list;
	}


	@HystrixCommand(fallbackMethod = "fallbackInsert") //1
	public List<Person> insert(String name) {
		return personService.insert(name);
	}

	public List<Person> fallbackInsert(String name){
		List<Person> list = new ArrayList<>();
		Person p = new Person(name+":::::::没有保存成功，Person Service 故障");
		list.add(p);
		return list;
	}
}
