package main.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import main.security.*;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  
	@Autowired
	private UserDetailsService userDetailsService;
	
	/*
	@Autowired
	public void configureAuthenticationManagerBuilder(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
	}
	*/
	
	@Autowired
	public void configureAuthenticationManagerBuilder(AuthenticationManagerBuilder auth) throws Exception {
        auth
        	.inMemoryAuthentication().withUser("username").password("password")
            .roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	      .httpBasic()
	    .and()
	      .authorizeRequests()
	        .antMatchers("/users", "/roles", "/logout", "/index.html", "/home.html", "/login.html", "/").permitAll()
	        .antMatchers("/vorstand/**").hasRole("ADMIN")
			.antMatchers("/**").hasRole("NORMALUSER")
	        .anyRequest().authenticated()
	    .and()
	    	.formLogin()
	    		.loginPage("/login.html")
	    		.usernameParameter("username")
				.passwordParameter("password")
				.permitAll()
	    .and()
	        .logout()
			.logoutSuccessUrl("/logout")
			.permitAll()
		.and()
			.csrf()
	        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
		web
        	.ignoring()
        	.antMatchers("/resources/**");
    }
}