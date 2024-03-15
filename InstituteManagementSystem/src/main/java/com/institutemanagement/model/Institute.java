package com.institutemanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;

//Entity class or POJO class

@Entity
@Builder
@Table(name="Institute")
public class Institute {
	
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private long id;
	private String instituteName;
	private String location;
	private String ContactInfo;
	
	//Getter and Setter
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getContactInfo() {
		return ContactInfo;
	}
	public void setContactInfo(String contactInfo) {
		ContactInfo = contactInfo;
	}
	@Override
	public String toString() {
		return "Institute [id=" + id + ", instituteName=" + instituteName + ", location=" + location + ", ContactInfo="
				+ ContactInfo + "]";
	}
	public Institute(long id, String instituteName, String location, String contactInfo) {
		super();
		this.id = id;
		this.instituteName = instituteName;
		this.location = location;
		ContactInfo = contactInfo;
	}
	
	public Institute() {
		
	}
	

}
