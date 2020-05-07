package com.capgemini.hcm.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DiagnosticCenter")
public class DiagnosticCenter {

	@Id
	@Column(name = "center_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "center_seq")
	@SequenceGenerator(sequenceName = "center_seq", initialValue = 1000, allocationSize = 1, name = "center_seq")
	private Integer centerId;

	@Column(name = "centerName")
	private String centerName;
	
	@OneToMany(targetEntity = Tests.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "center_Id", referencedColumnName = "center_Id")
	private List<Tests> testList=new ArrayList<>();

	public Integer getCenterId() {
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

	public List<Tests> getTestList() {
		return testList;
	}

	public void setTestList(List<Tests> testList) {
		this.testList = testList;
	}

	public DiagnosticCenter(Integer centerId, String centerName, List<Tests> testList) {
		super();
		this.centerId = centerId;
		this.centerName = centerName;
		this.testList = testList;
	}

	public DiagnosticCenter() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DiagnosticCenter [centerId=" + centerId + ", centerName=" + centerName + ", testList=" + testList + "]";
	}

	
}
