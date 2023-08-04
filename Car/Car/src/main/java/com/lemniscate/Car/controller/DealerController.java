package com.lemniscate.Car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lemniscate.Car.model.Dealer;
import com.lemniscate.Car.service.DealerService;

@RestController
public class DealerController  {
	
	@Autowired
	private DealerService dealerService;
	
	@PostMapping("/registerDealer")
	public ResponseEntity<Dealer> registerDealerHandler(@RequestBody Dealer dealer){
			
		Dealer deal=dealerService.registerDealer(dealer);
		
		return new ResponseEntity<Dealer>(deal,HttpStatus.ACCEPTED);
	}
	
}
