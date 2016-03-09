package fr.treeptik.tp.blog.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.treeptik.tp.blog.dao.AuthorDAO;
import fr.treeptik.tp.blog.model.Author;

@Component
public class AuthorValidator implements Validator {

	@Autowired
	private AuthorDAO repository;

	@Override
	public boolean supports(Class<?> arg0) {
		return arg0.getClass().equals(Author.class);
	}

	@Override
	public void validate(Object model, Errors errors) {

		Author m = (Author) model;

		if (m.getEmail() == null)
			errors.rejectValue("email", "saisie", "N'a pas saisie de mèl");
		else if(repository.emailExist(m.getEmail()))
			errors.rejectValue("email", "saisie", "Mèl déjà utilisé");
	}

}
