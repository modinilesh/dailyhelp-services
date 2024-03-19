package com.homecare.services.service;

import com.homecare.services.payload.ServiceProvidersDto;

public interface ServiceProviderService {
	
	ServiceProvidersDto createServiceProvider(ServiceProvidersDto serviceProviderDto, String serviceName); 

}
