package fr.treeptik.tp.blog.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.treeptik.tp.blog.dao.CommentDAO;
import fr.treeptik.tp.blog.model.Comment;

@Component
public class CommentValidator implements Validator  {

	@Autowired
	private CommentDAO repository;

	@Override
	public boolean supports(Class<?> arg0) {
		return arg0.getClass().equals(Comment.class);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
	}

}
