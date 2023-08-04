package com.lemniscate.Car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lemniscate.Car.model.Admin;
import com.lemniscate.Car.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminServ;
	
	@PostMapping("/registerAdmin")
	public ResponseEntity<Admin> registerAdminHandler(@RequestBody Admin admin){
			Admin adm=adminServ.registerAdmin(admin);
			return new ResponseEntity<Admin>(adm,HttpStatus.ACCEPTED);
	}

}
