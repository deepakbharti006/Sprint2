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
import javax.persistence.Table;

@Entity
@Table(name = "Test_table")
public class Tests {
	@Id
	@Column(name = "test_Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_seq")
	@SequenceGenerator(sequenceName = "test_seq", initialValue = 4000, allocationSize = 1, name = "test_seq")
	private Integer testId;

	@Column(name = "testName")
	private String testName;

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "test_Id", referencedColumnName = "test_Id")
	private List<Doctor> doctorlist;

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public List<Doctor> getDoctorlist() {
		return doctorlist;
	}

	public void setDoctorlist(List<Doctor> doctorlist) {
		this.doctorlist = doctorlist;
	}

	public Tests(Integer testId, String testName, List<Doctor> doctorlist) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.doctorlist = doctorlist;
	}

	public Tests() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Tests [testId=" + testId + ", testName=" + testName + ", doctorlist=" + doctorlist + "]";
	}

	
}
