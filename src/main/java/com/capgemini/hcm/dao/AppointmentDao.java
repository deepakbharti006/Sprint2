package com.capgemini.hcm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.hcm.entity.Appointment;

public interface AppointmentDao extends JpaRepository<Appointment, Integer>{

}
