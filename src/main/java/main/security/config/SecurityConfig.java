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
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import main.security.*;
import main.security.handler.RestAccessDeniedHandler;
import main.security.handler.RestAuthenticationSuccessHandler;
import main.security.handler.RestUnauthorizedEntryPoint;
import main.security.service.UserDetailsServiceImpl;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  
	@Autowired
	private RestUnauthorizedEntryPoint restAuthenticationEntryPoint;
	@Autowired
	private RestAuthenticationSuccessHandler restAuthenticationSuccessHandler;
	@Autowired
	private RestAccessDeniedHandler restAccessDeniedHandler;
	
	
    @Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	public void configureAuthenticationManagerBuilder(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
		    .headers().disable()
		    .csrf().disable()
		    /*.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		    .and()*/
		.authorizeRequests()
	        .antMatchers("/users", "/authenticate", "/roles", "/logout", "/index.html", "/home.html", "/login.html", "/").permitAll()
	        .antMatchers("/vorstand/**").hasRole("ADMIN")
			.antMatchers("/**").hasRole("NORMALUSER")
	        .anyRequest().authenticated()
	    .and()
		    .exceptionHandling()
		    .authenticationEntryPoint(restAuthenticationEntryPoint)
		    .accessDeniedHandler(restAccessDeniedHandler)
	    .and()
	    	.formLogin()
		    	.loginProcessingUrl("/authenticate")
				.successHandler(restAuthenticationSuccessHandler)
				.usernameParameter("username")
				.passwordParameter("password")
				.permitAll()
	    .and()
		    .logout()
			.invalidateHttpSession(false)
	        .logoutSuccessUrl("/logout")
	        .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
	        .deleteCookies("JSESSIONID")
			.permitAll();
	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
		web
        	.ignoring()
        	.antMatchers("/resources/**");
    }
}