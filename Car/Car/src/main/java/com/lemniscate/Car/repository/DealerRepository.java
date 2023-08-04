package com.lemniscate.Car.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lemniscate.Car.model.Dealer;

public interface DealerRepository extends JpaRepository<Dealer,Integer> {
	
	Optional<Dealer> findByDealerLicenseNumber(String licenseNumber);
}
