package com.lemniscate.Car.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lemniscate.Car.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	Optional<Admin> findByEmail (String adminEmail);
	
	
}
