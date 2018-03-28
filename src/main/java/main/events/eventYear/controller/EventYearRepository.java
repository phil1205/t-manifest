package main.events.eventYear.controller;

import main.events.eventYear.model.EventYear;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;


@RepositoryRestResource(path = "/eventYear")
public interface EventYearRepository extends PagingAndSortingRepository<EventYear, Long> {
	@Query("SELECT ey FROM EventYear ey ") //GROUP BY ey.shortYear
	List<EventYear> query();
}