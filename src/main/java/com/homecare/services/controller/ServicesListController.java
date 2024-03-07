package com.homecare.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homecare.services.payload.ServiceListDto;
import com.homecare.services.service.ServicesListService;

@RestController
@RequestMapping("/home-care/services")
public class ServicesListController {
	
	@Autowired
	private ServicesListService services;
	
	//create service
	@PostMapping("/create")
	public ResponseEntity<ServiceListDto> createService(@RequestBody ServiceListDto serviceListDto){
		return new ResponseEntity<ServiceListDto>(services.createService(serviceListDto), HttpStatus.CREATED);
	}

}
