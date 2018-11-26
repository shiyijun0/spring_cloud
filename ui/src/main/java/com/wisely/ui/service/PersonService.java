package com.wisely.ui.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.wisely.ui.domain.Person;

@FeignClient(value = "person")
public interface PersonService {
	 /*@RequestMapping(method = RequestMethod.POST, value = "/save",
	            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	 @ResponseBody List<Person> save( Person name);*/

	@RequestMapping(method = RequestMethod.POST, value = "/save")
	 List<Person> save(@RequestBody Person name);

	@RequestMapping(method = RequestMethod.POST, value = "/insert")
	List<Person> insert(@RequestParam("name") String name);
}
