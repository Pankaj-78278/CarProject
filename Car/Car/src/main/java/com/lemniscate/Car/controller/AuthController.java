package com.lemniscate.Car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lemniscate.Car.Exception.LoginException;
import com.lemniscate.Car.model.CurrentUserSession;
import com.lemniscate.Car.model.CustomerSignup;
import com.lemniscate.Car.model.LoginDTO;
import com.lemniscate.Car.service.CustomerSignUpService;
import com.lemniscate.Car.service.LoginService;

@RestController
public class AuthController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private CustomerSignUpService cserv;
//	
//	 @Autowired
//	    public LoginController(LoginService loginService) {
//	        this.loginService = loginService;
//	    }
	
	@PostMapping("/login")
	public ResponseEntity<CurrentUserSession> loginIntoAccountHandler(@RequestBody LoginDTO login) throws LoginException{
			
		CurrentUserSession cus=loginService.loginCustomer(login);
		return new ResponseEntity<CurrentUserSession> (cus,HttpStatus.OK);
	}
	
	@PostMapping("/register")
    public ResponseEntity<CustomerSignup> registerCustomerHandler(@RequestBody CustomerSignup customer) {
        CustomerSignup customerServ= cserv.registerCustomer(customer.getEmail(), customer.getPassword(), customer.getRole());
        
        return new ResponseEntity<CustomerSignup>(customerServ,HttpStatus.OK);
	}
	

	@GetMapping("/logout")
	public ResponseEntity<String>logoutFromAccountHandler(@RequestParam(required=false) String key ){ 
		String str=loginService.logoutCustomer(key);
	 return new ResponseEntity<String>(str,HttpStatus.OK); }
	
	
//	private final ClientRegistration azureRegistration;
//
//    @Autowired
//    public AuthController(ClientRegistrationRepository clientRegistrationRepository,
//                          OAuth2ClientProperties oAuth2ClientProperties) {
//        this.azureRegistration = clientRegistrationRepository.findByRegistrationId("azure");
//    }
//
//    @GetMapping("/login")
//    public String login() {
//        return "welcomme to the ms auth ";
//    }
//
//    @GetMapping("/home")
//    public ModelAndView home() {
//        return new ModelAndView( "home"); 
//    }
	 
}
