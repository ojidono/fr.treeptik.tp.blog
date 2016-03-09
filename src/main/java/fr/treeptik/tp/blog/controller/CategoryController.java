package fr.treeptik.tp.blog.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.treeptik.tp.blog.model.Category;
import fr.treeptik.tp.blog.service.CategoryService;

@Controller
@RequestMapping(value = "/category")
public class CategoryController extends GenericController<Category> {
	private CategoryService mainService;
	
	@Inject
	public CategoryController(CategoryService service){
		super(service);
		this.mainService=service;
	}
}
