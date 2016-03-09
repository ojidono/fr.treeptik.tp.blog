package fr.treeptik.tp.blog.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.tp.blog.service.GenericService;

@Service
public abstract class GenericServiceImpl<T, Pk extends Serializable> implements GenericService<T, Pk> {

    protected JpaRepository<T, Pk> generic;


	public GenericServiceImpl(JpaRepository<T, Pk> generic) {
		this.generic = generic;
	}
	public GenericServiceImpl() {}

	@Override
    @Transactional(propagation = Propagation.REQUIRED)
	public T save(T entity) {
		return generic.save(entity);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public T find(Pk id) {
		return generic.findOne(id);
	}

	@Override
    @Transactional(propagation = Propagation.REQUIRED)
	public void delete(T entity) {
		generic.delete(entity);
	}

	@Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<T> findAll() {
		return generic.findAll();
	}
}
