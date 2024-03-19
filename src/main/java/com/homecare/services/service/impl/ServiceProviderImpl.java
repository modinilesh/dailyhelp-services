package com.homecare.services.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homecare.services.entities.ServiceList;
import com.homecare.services.entities.ServiceProviders;
import com.homecare.services.payload.ServiceProvidersDto;
import com.homecare.services.repository.ServiceListRepository;
import com.homecare.services.repository.ServiceProviderRepository;
import com.homecare.services.service.ServiceProviderService;

@Service
public class ServiceProviderImpl implements ServiceProviderService {
	
	@Autowired
	private ServiceProviderRepository serviceProviderRepository;
	
	@Autowired
	private ServiceListRepository serviceListRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	

	@Override
	public ServiceProvidersDto createServiceProvider(ServiceProvidersDto serviceProviderDto, String serviceName) {
		//get ServiceList by ServiceName
		ServiceList serviceList = serviceListRepository.findByserviceName(serviceName);
		
		//map ServiceProvidersDto to ServiceProviders
		ServiceProviders provider = mapToProvider(serviceProviderDto);
		
		//set ServiceList to provider
		provider.setServiceId(serviceList);
		
		//save provider to DB
		ServiceProviders response = serviceProviderRepository.save(provider);
	
		return mapToDto(response);
	}
	
	
	
	//map to DTO
	ServiceProvidersDto mapToDto(ServiceProviders serviceProviders) {
		ServiceProvidersDto response = modelMapper.map(serviceProviders, ServiceProvidersDto.class);
		return response;
	}
	
	
	//map to ServiceProviders
	ServiceProviders mapToProvider(ServiceProvidersDto dto) {
		ServiceProviders provider = modelMapper.map(dto, ServiceProviders.class);
		return provider;
	}

}
