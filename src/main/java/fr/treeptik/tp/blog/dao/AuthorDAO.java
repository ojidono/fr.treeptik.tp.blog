package fr.treeptik.tp.blog.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.treeptik.tp.blog.model.Article;
import fr.treeptik.tp.blog.model.Author;

@Repository
public interface AuthorDAO extends JpaRepository<Author, Long> {
	public Author findById(Long id);
	
	@Query("SELECT aut FROM Author aut WHERE aut.email=?1")
	public Author findByEmail(String authorMel);
	
	@Query("SELECT COUNT(aut) FROM Author aut WHERE aut.email=?1")
	public boolean emailExist(String email);
	
	@Query("SELECT aut "
			+ "FROM Author aut "
				+ "JOIN FETCH aut.articles art "
				+ "JOIN FETCH art.comments c "
			+ "GROUP BY aut, art "
			+ "ORDER BY COUNT(c) DESC")
	public Author withArticleMostCommented();
	
	@Query("SELECT aut"
						+ " FROM Author aut JOIN FETCH aut.articles art"
						+ " WHERE art.published=true"
						+ " GROUP BY aut"
						+ " ORDER BY COUNT(art)")
	public List<Author> listByMostPublished();
	
	@Query("SELECT art FROM Author aut JOIN  aut.articles art WHERE aut.id =?1")
	public List<Article> getArticles(Long id);
}
