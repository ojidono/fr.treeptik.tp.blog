package fr.treeptik.tp.blog.service;

import java.util.List;

import fr.treeptik.tp.blog.model.Category;

public interface CategoryService extends GenericService<Category, Long> {
	public Long howManyArticles(Long id);
	public Category withMostArticles();
	public List<Category> withoutArticle();
	public Object getArticles(Long id);
	public Category getCategory(Long id);
}
