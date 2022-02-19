package com.webapplication.project.model;

import java.util.Collection;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



@Entity
@Table(name="tutor")
public class UserModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	//name should not be null or empty
	//name should have at least 2 characters
	@NotEmpty
	@Size(min=2,message="name should have at leat 2 characters")
	private String name;
	
	//email should not be null or empty
	//email should be a valid email format
	@NotEmpty
	@Email
	@Column(unique=true)
	private String email;
	
	//password should not be null or empty
	//password have at least 8 characters
	@NotEmpty
	@Size(min=8,message="password should have at leat 8 characters")
	private String password;
	
	
	@ManyToOne
	@JoinColumn(name = "user_medium_id")
	private MediumModel medium;
	

	

	

	
	
	public MediumModel getMedium() {
		return medium;
	}

	public void setMedium(MediumModel medium) {
		this.medium = medium;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "user_subjects",
			joinColumns = @JoinColumn(
		            name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
				            name = "subject_id", referencedColumnName = "id"))
	
	@NotEmpty
	private Collection<SubjectModel> subject;

	public Collection<SubjectModel> getSubject() {
		return subject;
	}

	public void setSubject(Collection<SubjectModel> subject) {
		this.subject = subject;
	}
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "up_id")
	private UserProfileModel userProfile;

	public UserProfileModel getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfileModel userProfile) {
		this.userProfile = userProfile;
	}
	
	

}
