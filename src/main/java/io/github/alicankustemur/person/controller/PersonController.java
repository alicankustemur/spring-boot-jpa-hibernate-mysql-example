package io.github.alicankustemur.person.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.github.alicankustemur.person.domain.Person;
import io.github.alicankustemur.person.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	@RequestMapping("/persons")
	@ResponseBody
	public Collection<Person> persons(){
		return service.getAllPersons();
	}
	
}
