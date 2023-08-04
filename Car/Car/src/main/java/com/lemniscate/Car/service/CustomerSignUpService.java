package com.lemniscate.Car.service;

import com.lemniscate.Car.model.CustomerSignup;

public interface CustomerSignUpService {
	
	public CustomerSignup registerCustomer(String email, String password, String role);
	
}
