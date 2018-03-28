package main.events.eventTask.controller;

import main.events.eventTask.model.EventTask;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;


@RepositoryRestResource(path = "/eventTasks")
public interface EventTaskRepository extends PagingAndSortingRepository<EventTask, Long> {
	
}