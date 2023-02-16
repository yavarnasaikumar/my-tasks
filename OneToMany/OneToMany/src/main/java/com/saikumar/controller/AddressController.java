package com.saikumar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saikumar.entity.Address;
import com.saikumar.entity.Employee;
import com.saikumar.repository.AddressRepository;
import com.saikumar.repository.EmployeeRepository;

@RestController
@CrossOrigin(origins = "http://localhost:8080/onetomany")
public class AddressController {

	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@GetMapping("/getAddress")
	public List<Address> getAddress() {
		return addressRepo.findAll();
	}
	
	@PostMapping("/saveAddress")
	public ResponseEntity<String> saveAddress(@RequestBody Address address) {
		addressRepo.save(address);
		return ResponseEntity.ok("Address saved");
	}
	
	@PutMapping("address/{addId}/employee/{empId}")
    public Address assignedAddressToEmployee(
            @PathVariable Long addId,
            @PathVariable Long empId
    ) {
        Address address = addressRepo.findById(addId).get();
        Employee employee = empRepo.findById(empId).get();
        address.setEmployee(employee);
        return addressRepo.save(address);
    }
	
}
