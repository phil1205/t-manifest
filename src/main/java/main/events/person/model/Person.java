package main.events.person.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.util.Assert;

import main.events.eventYear.model.EventYear;
import main.events.defaultTask.model.DefaultTask;
import main.security.role.model.Role;

@Entity
public class Person implements Serializable{
	
	public Person(String strFirstName, String strLastName) {
		Assert.hasText(strFirstName);
		Assert.hasText(strLastName);
		
		this.strFirstName = strFirstName;
		this.strLastName = strLastName;
	}
	
	protected Person() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="person_id")
	private Long LongPerson_id;
	
	@Column(name="firstName")
	private String strFirstName;
	
	@Column(name="lastName")
	private String strLastName;
	
	
	//getter & setter
	public Long getLongPerson_id() {
		return LongPerson_id;
	}

	public void setLongPerson_id(Long LongPerson_id) {
		this.LongPerson_id = LongPerson_id;
	}
 	
	public String getStrFirstName(){
		return this.strFirstName;
	}
	
	public void setStrFirstName(String strFirstName){
		this.strFirstName = strFirstName;
	}
	
	public String getStrLastName(){
		return this.strLastName;
	}
	
	public void setStrLastName(String strLastName){
		this.strLastName = strLastName;
	}
	
	
	@Override
	public String toString() {
		return "Person{" +
				"LongPerson_id=" + LongPerson_id +
				", strFirstName=" + strFirstName +
				", strLastName=" + strLastName +
				'}';
	}
}