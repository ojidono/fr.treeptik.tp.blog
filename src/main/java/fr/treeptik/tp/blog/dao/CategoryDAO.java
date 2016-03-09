package fr.treeptik.tp.blog.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.treeptik.tp.blog.model.Article;
import fr.treeptik.tp.blog.model.Category;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Long> {
	public Category findById(Long id);
	public List<Category> findByArticlesIsNull();

	@Query("SELECT COUNT(a) FROM Category c JOIN c.articles WHERE c.id = ?1")
	public Long howManyArticles(Long id);

	@Query("SELECT c"
					+ " FROM Category c JOIN FETCH c.articles a"
					+ " GROUP BY c"
					+ " ORDER BY COUNT (a) DESC")
	public Category withMostArticles();

	@Query("SELECT art FROM Category c JOIN c.articles art WHERE c.id= ?1")
	public List<Article> getArticles(Long id);
}
