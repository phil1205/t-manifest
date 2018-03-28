package main.events.defaultTask.controller;

import main.events.defaultTask.model.DefaultTask;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;


@RepositoryRestResource(path = "/defaultTasks")
public interface DefaultTaskRepository extends PagingAndSortingRepository<DefaultTask, Long> {
	
}