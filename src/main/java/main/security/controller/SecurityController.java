package main.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.security.SecurityUtils;
import main.security.user.controller.UserRepository;
import main.security.user.model.User;

@RestController
public class SecurityController {
	
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping(value = "/security/account", method = RequestMethod.GET)
	public @ResponseBody
	User getUserAccount() {
		User user = userRepo.findByStrUsername(SecurityUtils.getCurrentLogin());
		user.setStrPassword(null);
		return user;
	}
 
}