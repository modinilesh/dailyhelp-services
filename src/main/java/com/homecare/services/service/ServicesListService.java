package com.homecare.services.service;

import java.util.List;

import com.homecare.services.payload.ServiceListDto;

public interface ServicesListService {
	
	//creating Service
	ServiceListDto createService(ServiceListDto serviceListDto);
	public List<ServiceListDto> getAllServices();
	public ServiceListDto getServiceByName(String serviceName);

	public List<ServiceListDto> getServiceByType(String serviceType);

	public ServiceListDto updateServiceById(Long serviceId, ServiceListDto serviceListDto);
	//public ServiceListDto updateService(ServiceListDto serviceListDto);
	public String deleteService(ServiceListDto serviceListDto);
	public String deleteServiceById(Long serviceId);
}
