package io.github.alicankustemur.person.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import io.github.alicankustemur.person.domain.User;
import io.github.alicankustemur.person.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		for (User user : userService.getAllUsers()) {
			auth.inMemoryAuthentication()
					.withUser(user.getName())
					.password(user.getPassword())
					.roles(user.getRole().getName());
		}

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/persons/**")
			.access("hasRole('ROLE_ADMIN')")
			.and().formLogin();

	}

}