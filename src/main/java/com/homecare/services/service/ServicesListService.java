package com.homecare.services.service;

import java.util.List;

import com.homecare.services.payload.ServiceListDto;

public interface ServicesListService {
	
	//creating Service
	ServiceListDto createService(ServiceListDto serviceListDto);
	public String getAllServices();
	public ServiceListDto getServiceByName(String name);
}
