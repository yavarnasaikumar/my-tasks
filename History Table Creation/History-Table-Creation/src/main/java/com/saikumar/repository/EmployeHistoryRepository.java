package com.saikumar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saikumar.entity.EmployeHistory;

public interface EmployeHistoryRepository extends JpaRepository<EmployeHistory, Integer> {

}
