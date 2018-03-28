package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import main.events.defaultTask.controller.DefaultTaskRepository;
import main.events.defaultTask.model.DefaultTask;
import main.events.event.controller.EventRepository;
import main.events.event.model.Event;
import main.events.eventTask.controller.EventTaskRepository;
import main.events.eventTask.model.EventTask;
import main.events.eventYear.controller.EventYearRepository;
import main.events.eventYear.model.EventYear;
import main.events.person.controller.PersonRepository;
import main.events.person.model.Person;
import main.security.role.controller.RoleRepository;
import main.security.role.model.Role;
import main.security.user.controller.UserRepository;
import main.security.user.model.User;

@SpringBootApplication
public class Application {
	
	private final static Logger log = LoggerFactory.getLogger(Application.class);
	@Autowired UserRepository userRepository;
	@Autowired RoleRepository roleRepository;
	@Autowired DefaultTaskRepository defaultTaskRepository;
	@Autowired EventRepository eventRepository;
	@Autowired EventTaskRepository eventTaskRepository;
	@Autowired EventYearRepository eventYearRepository;
	@Autowired PersonRepository personRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(UserRepository userRepository, 
		RoleRepository roleRepository, 
		DefaultTaskRepository defaultTaskRepository, 
		EventRepository eventRepository, 
		EventTaskRepository eventTaskRepository, 
		EventYearRepository eventYearRepository, 
		PersonRepository personRepository) {
		    return (args) -> {
		    	// Event
		    	Event eventOA = new Event("Open Air");
		    	eventRepository.save(eventOA);
		    	
		    	// EventYear
		    	short year = 2017;
		    	EventYear eventOA17 = new EventYear(year);
		    	year = 2018;
		    	EventYear eventOA18 = new EventYear(year);
		    	year = 2019;
		    	EventYear eventOA19 = new EventYear(year);
		    	year = 2020;
		    	EventYear eventOA20 = new EventYear(year);
		    	eventYearRepository.save(eventOA17);
		    	eventYearRepository.save(eventOA18);
		    	eventYearRepository.save(eventOA19);
		    	eventYearRepository.save(eventOA20);
		    	
		    	// Person
		    	Person personPhil = new Person("Phil", "Bender");
		    	personRepository.save(personPhil);
		    	
		    	// DefaultTask
		    	DefaultTask defaultTaskDrinks = new DefaultTask("Getränke");
		    	defaultTaskRepository.save(defaultTaskDrinks);
		    	
		    	// EventTask
		    	EventTask eventTaskDrinks = new EventTask("Getränke", false);
		    	eventTaskRepository.save(eventTaskDrinks);
		    	
		    	// Login
		    	// Role
		    	Role roleMember = new Role("MEMBER");
		    	Role roleExecutive = new Role("EXECUTIVE");
		    	roleRepository.save(roleMember);
		    	roleRepository.save(roleExecutive);
		    	
		    	// User
		    	User userPhil = new User("phil", "phil");
		    	userRepository.save(userPhil);
		    };
	  }
}