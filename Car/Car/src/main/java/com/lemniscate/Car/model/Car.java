package com.lemniscate.Car.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
		
	private Integer carId;
	
	private String makeyYear;
	private String makeCompany;
	private String model;
	private String variant;
	
	private String odometer;
	private String zipCode;
	private String colorExterior;
	private String colorInterior;
	private Integer key;
	private Integer ownership;
	private String condition;
	private String status;
	
}
