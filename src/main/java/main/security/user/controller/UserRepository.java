package main.security.user.controller;

import main.security.user.model.User;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "/users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	//List<User> findByStrUsernameAndStrPassword(@Param("strUsername") String strUsername, @Param("strPassword") String strPassword);
	//User findByStrUsername(String strUsername);
}