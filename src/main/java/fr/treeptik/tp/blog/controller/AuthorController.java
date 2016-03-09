package fr.treeptik.tp.blog.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.treeptik.tp.blog.model.Author;
import fr.treeptik.tp.blog.service.AuthorService;

@Controller
@RequestMapping(value = "/author")
public class AuthorController extends GenericController<Author>{
	private AuthorService mainService;

	@Inject
	public AuthorController(AuthorService service){
		super(service);
		this.mainService=service;
	}
}
