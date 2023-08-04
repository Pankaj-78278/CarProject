package com.lemniscate.Car.serviceImpl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemniscate.Car.Exception.LoginException;
import com.lemniscate.Car.model.CurrentUserSession;
import com.lemniscate.Car.model.CustomerSignup;
import com.lemniscate.Car.model.LoginDTO;
import com.lemniscate.Car.repository.CustomerRepository;
import com.lemniscate.Car.repository.SessionRepository;
import com.lemniscate.Car.service.LoginService;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginSerivceImpl implements LoginService {

		@Autowired
	  private CustomerRepository customerRepository;
		
		@Autowired
	    private SessionRepository currentUserSessionRepository;


	    @Override
	    public CurrentUserSession loginCustomer(LoginDTO loginDTO) throws LoginException {
	        CustomerSignup existingCustomer = customerRepository.findByEmail(loginDTO.getEmail());
	        if (existingCustomer == null) {
	            throw new LoginException("Invalid email address or password");
	        }

	        Optional<CurrentUserSession> existingSessionOpt = currentUserSessionRepository.findById(existingCustomer.getCustomerId());
	        if (existingSessionOpt.isPresent()) {
	            throw new LoginException("Customer already logged in with this Email Address");
	        }

	        if (existingCustomer.getPassword().equals(loginDTO.getPassword())) {
	            String key = RandomString.make(6);
	            CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getCustomerId(), existingCustomer.getRole(),key, LocalDateTime.now());
	            currentUserSessionRepository.save(currentUserSession);
	            return currentUserSession;
	        } else {
	            throw new LoginException("Invalid email address or password");
	        }
	    }

	    @Override
	    public String logoutCustomer(String uuid) throws LoginException {
	        CurrentUserSession currentUserSession = currentUserSessionRepository.findByUuid(uuid);
	        if (currentUserSession == null) {
	            throw new LoginException("Customer not logged in with this session");
	        } else {
	            currentUserSessionRepository.delete(currentUserSession);
	            return "Customer Logged Out Successfully...!";
	        }
	    }


	



}
