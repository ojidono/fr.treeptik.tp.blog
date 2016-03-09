package fr.treeptik.tp.blog.conf;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import fr.treeptik.tp.blog.dao.ArticleDAO;
import fr.treeptik.tp.blog.dao.AuthorDAO;
import fr.treeptik.tp.blog.dao.CategoryDAO;
import fr.treeptik.tp.blog.dao.CommentDAO;
import fr.treeptik.tp.blog.service.impl.ArticleServiceImpl;
import fr.treeptik.tp.blog.service.impl.AuthorServiceImpl;
import fr.treeptik.tp.blog.service.impl.CategoryServiceImpl;
import fr.treeptik.tp.blog.service.impl.CommentServiceImpl;


@Configuration
@ComponentScan("fr.treeptik.tp.blog")
@EnableWebMvc
public class ServicesConfiguration {
	@Bean
	public ArticleServiceImpl articleServiceImpl(ArticleDAO repository) throws IOException, SQLException{
		return new ArticleServiceImpl(repository);
	}
	@Bean
	public AuthorServiceImpl authorServiceImpl(AuthorDAO repository) throws IOException, SQLException{
		return new AuthorServiceImpl(repository);
	}
	@Bean
	public CommentServiceImpl commentServiceImpl(CommentDAO repository) throws IOException, SQLException{
		return new CommentServiceImpl(repository);
	}
	@Bean
	public CategoryServiceImpl categoryServiceImpl(CategoryDAO repository) throws IOException, SQLException{
		return new CategoryServiceImpl(repository);
	}
}
