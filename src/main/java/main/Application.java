package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import main.security.role.controller.RoleRepository;
import main.security.role.model.Role;
import main.security.user.controller.UserRepository;
import main.security.user.model.User;

@SpringBootApplication
public class Application {
	
	private final static Logger log = LoggerFactory.getLogger(Application.class);
	@Autowired UserRepository ur;
	@Autowired RoleRepository rr;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(UserRepository ur, RoleRepository rr) {
	    return (args) -> {
	    	Role role1 = new Role("NORMALUSER");
	    	Role role2 = new Role("ADMIN");
	    	
	    	rr.save(role1);
	    	rr.save(role2);
	    	
	    	User user1 = new User("phil", "phil", 0L);
	    	ur.save(user1);
	    };
	  }
	  
	  @Bean
	  AppEventHandler appEventHandler() {
	      return new AppEventHandler();
	  }
}