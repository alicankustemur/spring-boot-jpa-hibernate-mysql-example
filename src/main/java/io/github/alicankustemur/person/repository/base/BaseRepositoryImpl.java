package io.github.alicankustemur.person.repository.base;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import io.github.alicankustemur.person.domain.base.AbstractEntity;

@Transactional
public class BaseRepositoryImpl<T extends AbstractEntity, ID extends Serializable> extends SimpleJpaRepository<T, ID>
		implements BaseRepository<T, ID> {

	private final EntityManager entityManager;

	public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
		this.entityManager = entityManager;
	}

	public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}
	
	public void insert(T entity) {
		if (entity.getRecordUpdateTime() == null) {
			entity.setRecordCreateTime(new Date());
			entity.setRecordIsDeleted(false);
			entityManager.persist(entity);
		}
	}

	public void update(T entity) {
		entity.setRecordUpdateTime(new Date());
		entityManager.persist(entity);
	}

	public Optional<T> softDeleteById(ID id) {
		T entity = entityManager.find(this.getDomainClass(), id);
		Optional<T> returned = Optional.empty();
		if (entity != null) {
			entity.setRecordUpdateTime(new Date());
			entity.setRecordIsDeleted(true);
			entityManager.persist(entity);
			returned = Optional.of(entity);
		}

		return returned;
	}
	
	public void deleteAll(){
		List<T> list = findAll();
		for(T entity : list){
			entityManager.remove(entity);
		}
		
	}
	
	public List<T> findAll() {
		return entityManager.createQuery("SELECT t FROM " + this.getDomainClass().getName() + " t").getResultList();
	}

	@Override
	public T findById(ID id) {
		T entity = entityManager.find(this.getDomainClass(), id);
		return entity;
	}

}