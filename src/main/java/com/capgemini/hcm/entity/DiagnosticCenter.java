package com.capgemini.hcm.entity;

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
import javax.persistence.SequenceGenerator;

@Entity
public class DiagnosticCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "centerId_generator")
	@SequenceGenerator(name = "centerId_generator", initialValue = 1001, allocationSize = 1)
	private Integer centerId;
	
	@Column(length = 25)
	private String centerName;
	
	@Column(length = 50)
	private String address;
	
	@Column(length = 10)
	private String contactNo;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = Test.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "center_no", referencedColumnName = "centerId")
	private List<Test> test;

	public long getCenterId() {
		return centerId;
	}

	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public List<Test> getTest() {
		return test;
	}

	public void setTest(List<Test> test) {
		this.test = test;
	}

	public DiagnosticCenter(Integer centerId, String centerName, String address, String contactNo, List<Test> test) {
		super();
		this.centerId = centerId;
		this.centerName = centerName;
		this.address = address;
		this.contactNo = contactNo;
		this.test = test;
	}

	public DiagnosticCenter() {

	}

	@Override
	public String toString() {
		return "DiagnosticCenter [centerId=" + centerId + ", centerName=" + centerName + ", address=" + address
				+ ", contactNo=" + contactNo + ", test=" + test + "]";
	}

}

