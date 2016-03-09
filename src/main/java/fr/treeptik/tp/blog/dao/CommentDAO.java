package fr.treeptik.tp.blog.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.treeptik.tp.blog.model.Article;
import fr.treeptik.tp.blog.model.Comment;

@Repository
public interface CommentDAO  extends JpaRepository<Comment, Long> {
	public List<Comment> findByArticle(Long id);

	@Query("SELECT art FROM Comment c JOIN c.article art WHERE c.id = ?1")
	public Article getArticle(Long id);
}
