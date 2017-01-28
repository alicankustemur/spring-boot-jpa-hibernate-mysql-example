package io.github.alicankustemur.person.repository;

import org.springframework.stereotype.Repository;

import io.github.alicankustemur.person.domain.Person;
import io.github.alicankustemur.person.repository.base.BaseRepository;

@Repository
public interface PersonRepository extends BaseRepository<Person, Long> {
	
}
