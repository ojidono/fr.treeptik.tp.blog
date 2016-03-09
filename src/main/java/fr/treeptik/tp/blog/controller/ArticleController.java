package fr.treeptik.tp.blog.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.treeptik.tp.blog.model.Article;
import fr.treeptik.tp.blog.service.ArticleService;
import fr.treeptik.tp.blog.service.AuthorService;
import fr.treeptik.tp.blog.service.CategoryService;

@Controller
@RequestMapping(value = "/article")
public class ArticleController extends GenericController<Article>{
	private ArticleService mainService;
	@Inject
	private AuthorService authorService;
	@Inject
	private CategoryService categoryService;

	@Inject
	public ArticleController(ArticleService service){
		super(service);
		this.mainService=service;
	}

	@RequestMapping(value = "/list/{type}/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Article> listArticleByType(@PathVariable(value="type") String type, @PathVariable(value="id") Long id) {
		List<Article> retour ;
		switch (type) {
			case "author":		retour =mainService.findByAuthor(		authorService.getAuthor(id));			break;
			case "category":	retour =mainService.findByCategory(	categoryService.getCategory(id));	break;
			default:					retour =mainService.findAll();
		}
		return retour;
	}
}
