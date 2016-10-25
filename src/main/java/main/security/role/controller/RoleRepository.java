package main.security.role.controller;

import main.security.role.model.Role;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "/roles")
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
	//List<User> findByStrUsernameAndStrPassword(@Param("strUsername") String strUsername, @Param("strPassword") String strPassword);
	//User findByStrUsername(String strUsername);
}