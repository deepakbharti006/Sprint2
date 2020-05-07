package com.capgemini.hcm.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Appointment_Details")
public class Appointment {
	@Id
	@Column(name = "appointment_Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_seq")
	@SequenceGenerator(sequenceName = "appointment_seq", initialValue = 011010, allocationSize = 1, name = "appointment_Id")
	private Long appointmentId;

	@Column(name = "Appointment_DateAndTime")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dateAndtime;

	@Column(name = "approved")
	private boolean approved;

	@ManyToOne(targetEntity = DiagnosticCenter.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "center_Id", referencedColumnName = "center_Id")
	private DiagnosticCenter diagnosticCenter;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private Users users;

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public LocalDateTime getDateAndtime() {
		return dateAndtime;
	}

	public void setDateAndtime(LocalDateTime dateAndtime) {
		this.dateAndtime = dateAndtime;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public DiagnosticCenter getDiagnosticCenter() {
		return diagnosticCenter;
	}

	public void setDiagnostic_center(DiagnosticCenter diagnosticCenter) {
		this.diagnosticCenter = diagnosticCenter;
	}

	public Users getUser() {
		return users;
	}

	public void setUser(Users users) {
		this.users = users;
	}

	public Appointment(Long appointmentId, LocalDateTime dateAndtime, boolean approved,
			DiagnosticCenter diagnosticCenter, Users users) {
		super();
		this.appointmentId = appointmentId;
		this.dateAndtime = dateAndtime;
		this.approved = approved;
		this.diagnosticCenter = diagnosticCenter;
		this.users = users;
	}

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", dateAndtime=" + dateAndtime + ", approved=" + approved
				+ ", diagnosticCenter=" + diagnosticCenter + ", user=" + users + "]";
	}
	
	
}
