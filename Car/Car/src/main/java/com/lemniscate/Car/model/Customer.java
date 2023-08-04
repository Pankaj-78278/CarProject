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
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String firstName;
	private String lastName;
	private String address;
	private String zipcode;
	private String phoneNumber;
	private String state;
	private String city;
	private String email;
	private String password;
	private String status;
	
	
}
