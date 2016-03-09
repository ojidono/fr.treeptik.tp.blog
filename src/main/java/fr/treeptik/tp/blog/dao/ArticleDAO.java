package fr.treeptik.tp.blog.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.treeptik.tp.blog.model.Article;
import fr.treeptik.tp.blog.model.Author;
import fr.treeptik.tp.blog.model.Category;
import fr.treeptik.tp.blog.model.Comment;

@Repository
public interface ArticleDAO extends JpaRepository<Article, Long> {
	public List<Article> findByPubDateBetween(Date letfDate, Date rightDate);
	public List<Article> findByCommentsNotNull();
	public List<Article> findByCategory(Category cat);
	public List<Article> findByAuthor(Author aut);

	@Query("SELECT aut FROM Article a JOIN a.author aut WHERE a.id = ?1")
	public Author getAuthor(Long id);
	@Query("SELECT cat FROM Article a JOIN a.category cat WHERE a.id = ?1")
	public Category getCategory(Long id);
	@Query("SELECT com FROM Article a JOIN a.comments com WHERE a.id = ?1")
	public List<Comment> getComments(Long id);
}
