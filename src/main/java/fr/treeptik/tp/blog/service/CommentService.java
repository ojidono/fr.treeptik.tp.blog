package fr.treeptik.tp.blog.service;

import java.util.List;

import fr.treeptik.tp.blog.model.Article;
import fr.treeptik.tp.blog.model.Comment;

public interface CommentService extends GenericService<Comment, Long> {
	public List<Comment> listComments(Long id);
	public Article getArticle(Long id);
}
