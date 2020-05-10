package com.capgemini.hcm.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Doctor {
	@Id
	@Column(name = "doctor_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctor_seq")
	@SequenceGenerator(sequenceName = "doctor_seq", initialValue = 3000, allocationSize = 1, name = "doctor_seq")
	private Integer doctorId;

	@NotEmpty(message = "name is mandatory")
	@Column(name = "doctor_Name")
	private String doctorName;

	@NotNull(message = "contact must be mandatory")
	@Column(name = "doctor_contact")
	private BigInteger contactNumber;

	@NotEmpty(message = "doctorSpecialization is mandatory")
	@Column(name = "doctor_Specialization")
	private String doctorSpecialization;

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public BigInteger getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(BigInteger contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getDoctorSpecialization() {
		return doctorSpecialization;
	}

	public void setDoctorSpecialization(String doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}

	public Doctor(Integer doctorId, @NotEmpty(message = "name is mandatory") String doctorName,
			@NotNull(message = "contact must be mandatory") BigInteger contactNumber,
			@NotEmpty(message = "doctorSpecialization is mandatory") String doctorSpecialization) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.contactNumber = contactNumber;
		this.doctorSpecialization = doctorSpecialization;
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", contactNumber=" + contactNumber
				+ ", doctorSpecialization=" + doctorSpecialization + "]";
	}

}
