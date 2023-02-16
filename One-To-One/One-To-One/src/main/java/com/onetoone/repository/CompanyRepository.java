package com.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.onetoone.entity.CompanyDetails;

public interface CompanyRepository extends JpaRepository<CompanyDetails, Long> {

}
