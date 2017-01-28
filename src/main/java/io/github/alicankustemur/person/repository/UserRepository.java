package io.github.alicankustemur.person.repository;

import org.springframework.stereotype.Repository;

import io.github.alicankustemur.person.domain.User;
import io.github.alicankustemur.person.repository.base.BaseRepository;

@Repository
public interface UserRepository extends BaseRepository<User, Long>{

}
