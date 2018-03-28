package main.events.person.controller;

import main.events.event.model.Event;
import main.events.person.model.Person;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;


@RepositoryRestResource(path = "/persons")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
	
}