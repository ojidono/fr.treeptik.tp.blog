package fr.treeptik.tp.blog.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import fr.treeptik.tp.blog.dao.AuthorDAO;
import fr.treeptik.tp.blog.model.Article;
import fr.treeptik.tp.blog.model.Author;
import fr.treeptik.tp.blog.service.AuthorService;

public class AuthorServiceImpl extends GenericServiceImpl<Author, Long> implements AuthorService {
	public AuthorServiceImpl() throws IOException, SQLException {}

	private AuthorDAO mainDAO;

	@Inject
	public AuthorServiceImpl(AuthorDAO author) {
		super(author);
		this.mainDAO = author;
	}

	@Override
	public Author withArticleMostCommented() {
		return mainDAO.withArticleMostCommented();
	}

	@Override
	public List<Author> listByMostPublished() {
		return mainDAO.listByMostPublished();
	}

	@Override
	public Author findByEmail(String authorMel) {
		return mainDAO.findByEmail(authorMel);
	}

	@Override
	public List<Article> getArticles(Long id) {
		return mainDAO.getArticles(id);
	}

	@Override
	public Author getAuthor(Long id) {
		return mainDAO.findById(id);
	}

}
