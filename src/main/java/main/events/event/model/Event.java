package main.events.event.model;

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
import javax.persistence.OneToMany;

import org.springframework.util.Assert;

import main.events.defaultTask.model.DefaultTask;
import main.events.eventYear.model.EventYear;

@Entity
public class Event implements Serializable{
	
	public Event(String strTitle) {
		Assert.hasText(strTitle);
		
		this.strTitle = strTitle;
	}
	
	public Event() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="event_id")
	private Long LongEvent_id;
	
	@Column(name="title")
	private String strTitle;
	
	@OneToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "event_id")
	private List<EventYear> eventYear = new ArrayList<EventYear>();
	
	@OneToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "event_id")
	private List<DefaultTask> defaultTask = new ArrayList<DefaultTask>();
	
	
	//getter & setter
	public Long getLongEvent_id() {
		return LongEvent_id;
	}

	public void setLongEvent_id(Long LongEvent_id) {
		this.LongEvent_id = LongEvent_id;
	}
 	
	public String getStrTitle(){
		return this.strTitle;
	}
	
	public void setStrTitle(String strTitle){
		this.strTitle = strTitle;
	}
	
	public List<EventYear> getEventYear() {
		return eventYear;
	}
 	
	public void addEventYear(EventYear eventYear) {
		Assert.notNull(eventYear);
		this.eventYear.add(eventYear);
	}
	
	public List<DefaultTask> getDefaultTask() {
		return defaultTask;
	}
 	
	public void addDefaultTask(DefaultTask defaultTask) {
		Assert.notNull(defaultTask);
		this.defaultTask.add(defaultTask);
	}
	
	
	@Override
	public String toString() {
		return "Event{" +
				"LongEvent_id=" + LongEvent_id +
				", strTitle=" + strTitle +
				", eventYear=" + eventYear +
				", eventYear=" + defaultTask +
				'}';
	}
}