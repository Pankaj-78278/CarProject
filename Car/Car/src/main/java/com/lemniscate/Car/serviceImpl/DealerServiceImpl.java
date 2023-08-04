package com.lemniscate.Car.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemniscate.Car.Exception.DealerException;
import com.lemniscate.Car.model.Dealer;
import com.lemniscate.Car.repository.DealerRepository;
import com.lemniscate.Car.service.DealerService;


@Service
public class DealerServiceImpl implements DealerService{
	
	@Autowired
	private DealerRepository dealerRepo;
	
	@Override
	public Dealer registerDealer(Dealer dealer) {
		if(dealerRepo.findByDealerLicenseNumber(dealer.getLicenseNumber()).isPresent()) throw new DealerException("License Number is already Exist");
		
		 return  dealerRepo.save(dealer);
		 
	}

	@Override
	public Dealer updateDealer(Dealer dealerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
