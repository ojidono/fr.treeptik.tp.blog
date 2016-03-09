package fr.treeptik.tp.blog.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import fr.treeptik.tp.blog.model.Article;
import fr.treeptik.tp.blog.model.Author;
import fr.treeptik.tp.blog.model.Category;
import fr.treeptik.tp.blog.model.Comment;

public interface ArticleService extends GenericService<Article, Long>{
	public List<Article> findByIntervall(Date leftD, Date rightD) throws ParseException;
	public List<Article> findByCategory(Category cat);
	public List<Article> findByAuthor(Author aut);
	public List<Article> findCommented();
	public Author getAuthor(Long id);
	public Category getCategory(Long id);
	public List<Comment> getComments(Long id);
}
