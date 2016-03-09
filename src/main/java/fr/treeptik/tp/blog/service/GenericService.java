package fr.treeptik.tp.blog.service;

import java.util.List;

public interface GenericService<T, Pk> {
	public T save (T entity);
	public T find (Pk id);
	public void delete(T entity);
	public List<T> findAll ();
}
