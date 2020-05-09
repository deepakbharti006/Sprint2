package com.capgemini.hcm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



@Entity
@Table(name = "User_Table")
public class Users {

	@Id
	@Column(name = "user_Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@SequenceGenerator(sequenceName = "user_seq", initialValue = 1, allocationSize = 1, name = "user_seq")
	private String userId;

	@NotEmpty(message = "user password is mandatory")
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{4,14}$")
	@Column(name = "userPaswword")
	private String userPassword;

	@NotEmpty(message = "user name is mandatory")
	@Column(name = "userName")
	private String userName;

	@NotNull(message = "contact must be mandatory")
	@Size(max = 10, message = "number must be of 10 digit")
	@Column(name = "contactNo")
	private Long contactNo;

	@Column(name = "userRole")
	private String userRole;

	@NotEmpty(message = "emailid is mandatory")
	@Column(name = "emailId")
	private String emailId;
	
	@OneToMany(targetEntity=DiagnosticCenter.class, cascade=CascadeType.ALL)
	@JoinColumn(name="user_Id",referencedColumnName="user_Id")
	private List<DiagnosticCenter> centerList;


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public List<DiagnosticCenter> getCenterList() {
		return centerList;
	}

	public void setCenterList(List<DiagnosticCenter> centerList) {
		this.centerList = centerList;
	}

	

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName + ", contactNo="
				+ contactNo + ", userRole=" + userRole + ", emailId=" + emailId + ", centerList=" + centerList + "]";
	}

	public Users(String userId, String userPassword, String userName, Long contactNo, String userRole, String emailId,List<DiagnosticCenter> centerList) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.contactNo = contactNo;
		this.userRole = userRole;
		this.emailId = emailId;
		this.centerList = centerList;

	}

	

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

}
