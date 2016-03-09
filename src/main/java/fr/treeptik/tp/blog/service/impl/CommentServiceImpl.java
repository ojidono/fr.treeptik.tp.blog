package fr.treeptik.tp.blog.service.impl;

import java.util.List;

import javax.inject.Inject;

import fr.treeptik.tp.blog.dao.CommentDAO;
import fr.treeptik.tp.blog.model.Article;
import fr.treeptik.tp.blog.model.Comment;
import fr.treeptik.tp.blog.service.CommentService;

public class CommentServiceImpl extends GenericServiceImpl<Comment, Long> implements
		CommentService {

	private CommentDAO mainDAO;

	@Inject
	public CommentServiceImpl(CommentDAO comment) {
		super(comment);
		this.mainDAO = comment;
	}

	@Override
	public List<Comment> listComments(Long id) {
		return mainDAO.findByArticle(id);
	}

	@Override
	public Article getArticle(Long id) {
		return mainDAO.getArticle(id);
	}

}
