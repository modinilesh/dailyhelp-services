package com.homecare.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@GetMapping
	public ResponseEntity<List<ServiceListDto>> getAllServices(){
		return new ResponseEntity<List<ServiceListDto>>(services.getAllServices(),HttpStatus.OK);
	}

	@GetMapping("/name/{serviceName}")
	public ResponseEntity<ServiceListDto> getServiceByName(@PathVariable(name="serviceName") String serviceName){
		return new ResponseEntity<ServiceListDto>(services.getServiceByName(serviceName),HttpStatus.OK);
	}

	@GetMapping("/type/{serviceType}")
	public ResponseEntity<List<ServiceListDto>> getServiceByType(@PathVariable(name="serviceType") String serviceType){
		return new ResponseEntity<List<ServiceListDto>>(services.getServiceByType(serviceType),HttpStatus.OK);
	}

	@PutMapping("/update/{serviceId}")
	public ResponseEntity<ServiceListDto> updateServiceById(@PathVariable("serviceId") Long serviceId,@RequestBody ServiceListDto serviceListDto){
		return new ResponseEntity<ServiceListDto>(services.updateServiceById(serviceId, serviceListDto), HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteService(@RequestBody ServiceListDto serviceListDto){
		return new ResponseEntity<String>(services.deleteService(serviceListDto), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{serviceId}")
	public ResponseEntity<String> deleteService(@PathVariable("serviceId") Long serviceId){
		return new ResponseEntity<String>(services.deleteServiceById(serviceId), HttpStatus.OK);
	}


}
