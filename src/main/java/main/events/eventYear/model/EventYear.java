package main.events.eventYear.model;

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

import main.events.eventTask.model.EventTask;

@Entity
public class EventYear implements Serializable{
	
	public EventYear(short shortYear) {
		Assert.notNull(shortYear);
		
		this.shortYear = shortYear;
	}
	
	public EventYear() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="eventYear_id")
	private Long LongEventYear_id;
	
	@Column(name="year")
	private short shortYear;
	
	@OneToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "event_id")
	private List<EventTask> eventTasks = new ArrayList<EventTask>();
	
	
	//getter & setter
	public Long getLongEventYear_id() {
		return LongEventYear_id;
	}

	public void setLongEventYear_id(Long LongEventYear_id) {
		this.LongEventYear_id = LongEventYear_id;
	}
 	
	public short getShortYear(){
		return this.shortYear;
	}
	
	public void setShortYear(short shortYear){
		this.shortYear = shortYear;
	}
	
	public List<EventTask> getEventTask() {
		return eventTasks;
	}
 	
	public void addEventask(EventTask eventTask) {
		Assert.notNull(eventTask);
		this.eventTasks.add(eventTask);
	}
	
	
	@Override
	public String toString() {
		return "EventYear{" +
				"LongEventYear_id=" + LongEventYear_id +
				", shortYear=" + shortYear +
				", eventTasks=" + eventTasks +
				'}';
	}
}