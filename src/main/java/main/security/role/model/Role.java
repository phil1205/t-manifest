package main.security.role.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.util.Assert;

import main.security.user.model.User;

@Entity
public class Role implements Serializable{
	
public Role(String strType) {
		Assert.hasText(strType);
		
		this.strType = strType;
	  }
	
	protected Role() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="role_id")
	private Long LongRole_id;
	
	@Column(name="type")
	private String strType;
	
	
	//getter & setter
	public Long getLongRole_id() {
		return LongRole_id;
	}

	public void setLongRole_id(Long LongRole_id) {
		this.LongRole_id = LongRole_id;
	}
 	
	public String getStrType(){
		return this.strType;
	}
	
	public void setStrType(String strType){
		this.strType = strType;
	}
	
 	
 	@Override
	public String toString() {
		return "Role{" +
				"LongRole_id=" + LongRole_id +
				", strType=" + strType +
				'}';
	}
}