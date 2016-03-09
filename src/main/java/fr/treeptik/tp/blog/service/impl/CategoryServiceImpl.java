package fr.treeptik.tp.blog.service.impl;

import java.util.List;

import javax.inject.Inject;

import fr.treeptik.tp.blog.dao.CategoryDAO;
import fr.treeptik.tp.blog.model.Category;
import fr.treeptik.tp.blog.service.CategoryService;

public class CategoryServiceImpl extends GenericServiceImpl<Category, Long> implements CategoryService {

	private CategoryDAO mainDAO;

	@Inject
	public CategoryServiceImpl(CategoryDAO category) {
		super(category);
		this.mainDAO = category;
	}

	@Override
	public Long howManyArticles(Long id) {
		return mainDAO.howManyArticles(id);
	}

	@Override
	public Category withMostArticles() {
		return mainDAO.withMostArticles();
	}

	@Override
	public List<Category> withoutArticle() {
		return mainDAO.findByArticlesIsNull();
	}

	@Override
	public Object getArticles(Long id) {
		return mainDAO.getArticles(id);
	}

	@Override
	public Category getCategory(Long id) {
		return mainDAO.findById(id);
	}

}
