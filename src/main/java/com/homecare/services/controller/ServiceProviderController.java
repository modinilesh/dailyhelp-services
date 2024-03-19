package com.homecare.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homecare.services.payload.ServiceProvidersDto;
import com.homecare.services.service.ServiceProviderService;

@RestController
@RequestMapping("/home-care/services")
public class ServiceProviderController {
	

	@Autowired
	private ServiceProviderService serviceProviderService;
	
	//create service
	@PostMapping("/{serviceName}/serviceProviders/create")
	public ResponseEntity<ServiceProvidersDto> createServiceProvider(@PathVariable(name = "serviceName") String serviceName,@RequestBody ServiceProvidersDto serviceProvidersDto){
		return new ResponseEntity<ServiceProvidersDto>(serviceProviderService.createServiceProvider(serviceProvidersDto, serviceName), HttpStatus.CREATED);
	}

}
