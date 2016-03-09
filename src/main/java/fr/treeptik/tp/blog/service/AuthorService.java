package fr.treeptik.tp.blog.service;

import java.util.List;

import fr.treeptik.tp.blog.model.Article;
import fr.treeptik.tp.blog.model.Author;

public interface AuthorService extends GenericService<Author, Long> {
	public Author withArticleMostCommented();
	public List<Author> listByMostPublished();
	public Author findByEmail(String authorMel);
	public List<Article> getArticles(Long id);
	public Author getAuthor(Long id);
}
