package main.guestbook.controller;

import main.guestbook.model.Guestbook;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;


@RepositoryRestResource(path = "/guestbooks")
public interface GuestbookRepository extends PagingAndSortingRepository<Guestbook, Long> {
	
}