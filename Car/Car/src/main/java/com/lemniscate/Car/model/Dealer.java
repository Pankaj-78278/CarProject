package com.lemniscate.Car.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dealer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer dealerId;
	private String dealerName;
	private String dealerRegistrationName;
	
	private String licenseNumber;
	
	private String dealerAddress;
	
	private String dealerCity;
	
	private String dealerState;
	
	private String dealerZipCode;
	
	private String dealerEmail;
	private String status;
}
