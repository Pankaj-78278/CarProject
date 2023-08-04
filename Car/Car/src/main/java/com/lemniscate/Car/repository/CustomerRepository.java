package com.lemniscate.Car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lemniscate.Car.model.CustomerSignup;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerSignup, Integer>{
	
	public CustomerSignup findByEmail(String email);
	

}
