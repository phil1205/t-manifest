package main.events.eventTask.model;

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

import org.springframework.util.Assert;

import main.events.person.model.Person;
import main.guestbook.*;

@Entity
public class EventTask implements Serializable{
	
	public EventTask(String strTitle, Boolean bolChecked) {
		Assert.hasText(strTitle);
		Assert.notNull(bolChecked);
		
		this.strTitle = strTitle;
		this.bolChecked = bolChecked;
	}
	
	protected EventTask() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="eventTask_id")
	private Long LongEventTask_id;
	
	@Column(name="title")
	private String strTitle;
	
	@Column(name="checked")
	private Boolean bolChecked;
	
	@ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
	@JoinTable(name="person_eventTask", joinColumns=@JoinColumn(name="eventTask_id"), inverseJoinColumns=@JoinColumn(name="person_id"))
	private List<Person> persons = new ArrayList<Person>();
	
	
	//getter & setter
	public Long getLongEventTask_id() {
		return LongEventTask_id;
	}

	public void setLongEventTask_id(Long LongEventTask_id) {
		this.LongEventTask_id = LongEventTask_id;
	}
 	
	public String getStrTitle(){
		return this.strTitle;
	}
	
	public void setStrTitle(String strTitle){
		this.strTitle = strTitle;
	}
	
	public Boolean getBolChecked(){
		return this.bolChecked;
	}
	
	public void setBolChecked(Boolean bolChecked){
		this.bolChecked = bolChecked;
	}
	
	public List<Person> getPerson(){
		return this.persons;
	}
	
	public void setPerson(Person person){
		Assert.notNull(person);
		this.persons.add(person);
	}
	
	
	@Override
	public String toString() {
		return "EventTask{" +
				"LongEventTask_id=" + LongEventTask_id +
				", strTitle=" + strTitle +
				", bolChecked=" + bolChecked +
				", person=" + persons +
				'}';
	}
}