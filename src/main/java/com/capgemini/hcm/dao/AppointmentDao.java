package com.capgemini.hcm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.hcm.entity.TestAppointment;

public interface AppointmentDao extends JpaRepository<TestAppointment, Integer>{

}
