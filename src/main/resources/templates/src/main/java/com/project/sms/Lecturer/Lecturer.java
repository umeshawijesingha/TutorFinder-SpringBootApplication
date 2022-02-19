package com.project.sms.Lecturer;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import com.project.sms.subject.Subject;



@Entity
public class Lecturer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(name="lecturer_fullname")
	@NotEmpty(message = "Enter your name")
		private String name;
	

	
	@Column(name="lecturer_address")
	@NotEmpty(message = "Enter your address")
	private String address;
	

	@Column(name="lecturer_dob")
	@NotEmpty(message = "Enter your dob")
	private String dob;
	
	@OneToOne
	@JoinColumn(name="subject_id")
	private Subject subject;
	
	public Lecturer() {
		
	}
	
	public Lecturer(String name) {
		super();
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Lecturer [id=" + id + ", name=" + name + ", address=" + address + ", dob=" + dob + ", subject="
				+ subject + "]";
	}
	
	

}
