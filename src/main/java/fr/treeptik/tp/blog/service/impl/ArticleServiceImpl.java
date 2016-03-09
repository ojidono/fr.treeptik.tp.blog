package fr.treeptik.tp.blog.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import fr.treeptik.tp.blog.dao.ArticleDAO;
import fr.treeptik.tp.blog.model.Article;
import fr.treeptik.tp.blog.model.Author;
import fr.treeptik.tp.blog.model.Category;
import fr.treeptik.tp.blog.model.Comment;
import fr.treeptik.tp.blog.service.ArticleService;

@Service
public class ArticleServiceImpl extends GenericServiceImpl<Article, Long> implements ArticleService{
	public ArticleServiceImpl() throws IOException, SQLException {}

	private ArticleDAO mainDAO;

	@Inject
	public ArticleServiceImpl(ArticleDAO article) {
		super(article);
		this.mainDAO = article;
	}
	
	@Override
	public List<Article> findByIntervall(Date leftD, Date rightD) throws ParseException {
		return mainDAO.findByPubDateBetween(leftD, rightD);
	}

	@Override
	public List<Article> findCommented() {
		return mainDAO.findByCommentsNotNull();
	}

	@Override
	public Author getAuthor(Long id) {
		return mainDAO.getAuthor(id);
	}

	@Override
	public Category getCategory(Long id) {
		return mainDAO.getCategory(id);
	}

	@Override
	public List<Comment> getComments(Long id) {
		return mainDAO.getComments(id);
	}

	@Override
	public List<Article> findByCategory(Category cat) {
		return mainDAO.findByCategory(cat);
	}

	@Override
	public List<Article> findByAuthor(Author aut) {
		return mainDAO.findByAuthor(aut);
	}

}
