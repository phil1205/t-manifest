package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import main.security.user.controller.UserRepository;
import main.security.user.model.User;

@SpringBootApplication
public class Application {
	
	private final static Logger log = LoggerFactory.getLogger(Application.class);
	@Autowired UserRepository up;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	  public CommandLineRunner demo(UserRepository up) {
	    return (args) -> {
	      // some persons
	      User user1 = new User("phil", "phil");

	      up.save(user1);
	    };
	  }
	  
	  @Bean
	  AppEventHandler appEventHandler() {
	      return new AppEventHandler();
	  }

}