package main.events.defaultTask.model;

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
public class DefaultTask implements Serializable{
	
	public DefaultTask(String strTitle) {
		Assert.hasText(strTitle);
		
		this.strTitle = strTitle;
	}
	
	protected DefaultTask() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="defaultTask_id")
	private Long LongDefaultTask_id;
	
	@Column(name="title")
	private String strTitle;
	
	
	//getter & setter
	public Long getLongDefaultTask_id() {
		return LongDefaultTask_id;
	}

	public void setLongDefaultTask_id(Long LongDefaultTask_id) {
		this.LongDefaultTask_id = LongDefaultTask_id;
	}
 	
	public String getStrTitle(){
		return this.strTitle;
	}
	
	public void setStrTitle(String strTitle){
		this.strTitle = strTitle;
	}
	
	
	@Override
	public String toString() {
		return "DefaultTask{" +
				"LongDefaultTask_id=" + LongDefaultTask_id +
				", strTitle=" + strTitle +
				'}';
	}
}