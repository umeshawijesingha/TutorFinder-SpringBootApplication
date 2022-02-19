package com.project.sms.Student;

import java.util.HashSet;
import java.util.Set;

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
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.project.sms.Department.Department;
import com.project.sms.course.Course;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(name="std_fullname")
	@NotEmpty(message = "Enter your name")
		private String name;
	

	
	@Column(name="std_address")
	@NotEmpty(message = "Enter your address")
	private String address;
	

	@Column(name="std_dob")
	@NotEmpty(message = "Enter your dob")
	private String dob;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name="course_student",
				joinColumns = {@JoinColumn(name = "student_id")},
				inverseJoinColumns = {@JoinColumn (name="course_id")})

	private Set<Course> course = new HashSet<>();
	
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	public Student() {
		
	}
	
	public Student(String name) {
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	public Set<Course> getCourse() {
		return course;
	}

	public void setCourse(Set<Course> course) {
		this.course = course;
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

}
