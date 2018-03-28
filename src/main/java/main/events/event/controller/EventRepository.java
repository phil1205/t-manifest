package main.events.event.controller;

import main.events.event.model.Event;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;


@RepositoryRestResource(path = "/events")
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
	
}