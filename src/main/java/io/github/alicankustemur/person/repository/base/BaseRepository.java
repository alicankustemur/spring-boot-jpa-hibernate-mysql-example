package io.github.alicankustemur.person.repository.base;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {

	public void insert(T entity);

	public void update(T entity);

	public Optional<T> softDeleteById(ID id);
	
	public void deleteAll();
	
	public List<T> findAll();
	
	public T findById(ID id);
}