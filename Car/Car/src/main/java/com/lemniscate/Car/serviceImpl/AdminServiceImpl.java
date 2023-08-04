package com.lemniscate.Car.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemniscate.Car.Exception.AdminException;
import com.lemniscate.Car.model.Admin;
import com.lemniscate.Car.repository.AdminRepository;
import com.lemniscate.Car.service.AdminService;

import net.bytebuddy.implementation.bytecode.Throw;
@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepo;
	

	@Override
	public Admin registerAdmin(Admin admin) {
		if(adminRepo.findByEmail(admin.getAdminEmail()).isPresent()) throw new AdminException("This Email address is already Exist");
		
		return adminRepo.save(admin);
	}

}
