package com.saikumar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saikumar.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
