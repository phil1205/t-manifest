package main.security.user.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.util.Assert;

import main.guestbook.*;
//import main.security.role.model.Role;

@Entity
public class User implements Serializable{
	
	public User(String strUsername, String strPassword) {
		
		Assert.hasText(strUsername);
	    Assert.hasText(strPassword);

	    this.strUsername = strUsername;
	    this.strPassword = strPassword;
	  }
	
	protected User() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private Long LongUser_id;
	
	@Column(name="name")
	private String strUsername;
	
	@Column(name="EMail")
	private String strPassword;
	
	/*
	@ManyToOne(targetEntity = Role.class)
	@JoinColumn(name = "role_id", referencedColumnName = "role_id")
	private Role roles;
	*/
	
	
	//getter & setter
	public Long getLongUser_id() {
		return LongUser_id;
	}

	public void setLongUser_id(Long LongUser_id) {
		this.LongUser_id = LongUser_id;
	}
 	
	public String getStrUsername(){
		return this.strUsername;
	}
	
	public void setStrUsername(String strUsername){
		this.strUsername = strUsername;
	}
	
	public String getStrPassword(){
		return this.strPassword;
	}
	
	public void setStrPassword(String strPassword){
		this.strPassword = strPassword;
	}
	
 	
 	@Override
	public String toString() {
		return "User{" +
				"LongUser_id=" + LongUser_id +
				", strUsername=" + strUsername +
				", strPassword=" + strPassword +
				/*", roles=" + roles +*/
				'}';
	}
}