package com.capgemini.hcm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.hcm.entity.Tests;

public interface TestDao extends JpaRepository<Tests, Integer> {

}
