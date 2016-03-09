package fr.treeptik.tp.blog.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.treeptik.tp.blog.service.GenericService;

public class GenericController <T>{
	public GenericService<T, Long> genericService;
	
	public GenericController(GenericService<T, Long> service){
		this.genericService = service;
	}

	@RequestMapping(value = "/list/all", method = RequestMethod.GET)
	public @ResponseBody List<T> list() {
		return genericService.findAll();
	}

	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public @ResponseBody T detail(@PathVariable(value="id") Long id) {
		return genericService.find(id);
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public T save(@RequestBody T entity) {
		return genericService.save(entity);
	}
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public @ResponseBody T delete(@RequestBody T entity) {
		genericService.delete(entity);
		return entity;
	}
}
