package fr.treeptik.tp.blog.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.treeptik.tp.blog.model.Comment;
import fr.treeptik.tp.blog.service.CommentService;

@Controller
@RequestMapping(value = "/comment")
public class CommentController extends GenericController<Comment>{
	private CommentService mainService;
	
	@Inject
	public CommentController(CommentService service){
		super(service);
		this.mainService=service;
	}
}
