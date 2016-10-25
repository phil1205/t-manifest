package main.guestbook.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.util.Assert;

import main.guestbook.*;

@Entity
public class Guestbook implements Serializable{
	
	public Guestbook(){
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="entry_id")
	private Long LongEntry_id;
	
	@Column(name="name")
	private String strName;
	
	@Column(name="EMail")
	private String strEMail;
	
	@Column(name="entry")
	private String strEntry;
	
	@Column(name="date")
	private String strDate;

	@Column(name="accepted")
	private byte byteAccepted;
	
	
	//getter & setter
	public Long getLongEntry_id() {
		return LongEntry_id;
	}

	public void setLongEntry_id(Long LongEntry_id) {
		this.LongEntry_id = LongEntry_id;
	}
 	
	public String getStrName(){
		return this.strName;
	}
	
	public void setStrName(String strName){
		this.strName = strName;
	}
	
	public String getStrEMail(){
		return this.strEMail;
	}
	
	public void setStrEMail(String strEMail){
		this.strEMail = strEMail;
	}
	
	public String getStrEntry(){
		return this.strEntry;
	}
	
	public void setStrEntry(String strEntry){
		this.strEntry = strEntry;
	}
	
	public String getStrDate(){
		return this.strDate;
	}
	
	public void setStrDate(String strDate){
		this.strDate = strDate;
	}
	
	public byte getByteAccepted(){
		return this.byteAccepted;
	}
	
	public void setByteAccepted(byte byteAccepted){
		this.byteAccepted = byteAccepted;
	}
 	
 	@Override
	public String toString() {
		return "Guestbook{" +
				"LongEntry_id=" + LongEntry_id +
				", strName=" + strName +
				", strEMail=" + strEMail +
				", strEntry=" + strEntry +
				", strDate=" + strDate +
				", byteAccepted=" + byteAccepted +
				'}';
	}
}