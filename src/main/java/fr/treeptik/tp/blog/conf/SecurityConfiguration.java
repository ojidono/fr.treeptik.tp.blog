package fr.treeptik.tp.blog.conf;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Inject
	private DataSource dataSource;

	@Bean
	@Override
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/*/**");
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
				.dataSource(dataSource)
				.usersByUsernameQuery(
						"Select nom, password, 'true' as enabled From client c where c.nom=?")
				.authoritiesByUsernameQuery(
						"Select c.nom, r.description from role r join client c on c.role_id=r.id where c.nom=?");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.formLogin().loginPage("/login")
				.usernameParameter("j_username")
				.loginProcessingUrl("/j_spring_security_check")
				.passwordParameter("j_password")
				.failureUrl("/login?error")
				.defaultSuccessUrl("/rest/list", true).and()
			.logout()
				.logoutUrl("/logout")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID").and()
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/client/**", "/rest/**", "/")
				.hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
				.antMatchers("/login")
				.permitAll();
	}
}