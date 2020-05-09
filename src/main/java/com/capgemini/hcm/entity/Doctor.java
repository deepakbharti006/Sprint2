package com.capgemini.hcm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Doctor_Table")
public class Doctor {
	@Id
	@Column(name = "doctor_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctor_seq")
	@SequenceGenerator(sequenceName = "doctor_seq", initialValue = 1010, allocationSize = 1, name = "doctor_seq")
	private Integer doctorId;
	
	@NotEmpty(message="name is mandatory")
	@Column(name = "doctor_Name")
	private String doctorName;
	
	@NotNull(message = "contact must be mandatory")
	@Size(max = 10, message = "number must be of 10 digit")
	@Column(name="doctor_contact")
	private Long contactNumber;
	
	@NotEmpty(message="doctorSpecialization is mandatory")
	@Column(name = "doctor_Specialization")
	private String doctorSpecialization;

	@OneToOne( cascade=CascadeType.ALL)
	@JoinColumn(name="test_Id",referencedColumnName = "test_Id")
	private Tests tests;

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getDoctorSpecialization() {
		return doctorSpecialization;
	}

	public void setDoctorSpecialization(String doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}

	public Tests getTests() {
		return tests;
	}

	public void setTests(Tests tests) {
		this.tests = tests;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", contactNumber=" + contactNumber
				+ ", doctorSpecialization=" + doctorSpecialization + ", tests=" + tests + "]";
	}

	public Doctor(int doctorId, @NotEmpty(message = "name is mandatory") String doctorName,
			@NotNull(message = "contact must be mandatory") @Size(max = 10, message = "number must be of 10 digit") Long contactNumber,
			@NotEmpty(message = "doctorSpecialization is mandatory") String doctorSpecialization, Tests tests) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.contactNumber = contactNumber;
		this.doctorSpecialization = doctorSpecialization;
		this.tests = tests;
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

