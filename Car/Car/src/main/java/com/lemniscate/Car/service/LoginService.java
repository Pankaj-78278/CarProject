package com.lemniscate.Car.service;

import com.lemniscate.Car.Exception.LoginException;
import com.lemniscate.Car.model.CurrentUserSession;
import com.lemniscate.Car.model.CustomerSignup;
import com.lemniscate.Car.model.LoginDTO;

public interface LoginService {
	

	 public CurrentUserSession loginCustomer(LoginDTO loginDTO) throws LoginException;
	
	/* public String LogoutFromAccount(String key) throws LoginException; */
	 public String logoutCustomer(String uuid) throws LoginException;
	



}
