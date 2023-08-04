package com.lemniscate.Car.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemniscate.Car.Exception.CustomerException;
import com.lemniscate.Car.model.CustomerSignup;
import com.lemniscate.Car.repository.CustomerRepository;
import com.lemniscate.Car.service.CustomerSignUpService;

@Service
public class CustomerServiceImpl implements CustomerSignUpService {
	
//	@Autowired
//	private static final String DEFAULT_ROLE = "ROLE_CUSTOMER";
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


@Override
public CustomerSignup registerCustomer(String email, String password, String role) {
	  CustomerSignup existingCustomer = customerRepository.findByEmail(email);
      if (existingCustomer != null) {
          throw new CustomerException("Customer already exists with this Email");
      }

      CustomerSignup customer = new CustomerSignup();
      customer.setEmail(email);
      customer.setPassword(password);
      customer.setRole(role);
      return customerRepository.save(customer);
  }
}

	

