package io.github.alicankustemur.person.service;

import java.util.List;

import io.github.alicankustemur.person.domain.Person;
import io.github.alicankustemur.person.repository.PersonRepository;

public interface PersonService {

	public List<Person> getAllPersons();

	public Person getPersonById(Long id);
	
	public void addPerson(Person person);

	public void removePersonById(Long id);
	
	
}
