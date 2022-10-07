package com.postgres.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postgres.entity.EmployeeDetails;

public interface EmployeeDetailsRepo extends JpaRepository<EmployeeDetails, Integer>{


}
