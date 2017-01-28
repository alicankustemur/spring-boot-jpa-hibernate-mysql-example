package io.github.alicankustemur.person.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.alicankustemur.person.domain.User;
import io.github.alicankustemur.person.repository.UserRepository;
import io.github.alicankustemur.person.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public List<User> getAllUsers() {
		return repository.findAll();
	}

}
