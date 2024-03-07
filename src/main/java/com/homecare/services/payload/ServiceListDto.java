package com.homecare.services.payload;

import java.util.ArrayList;
import java.util.List;

import com.homecare.services.entities.ServiceProviders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ServiceListDto {
	
	private Long serviceId;
	
	private String serviceName;
	
	private String serviceType;
	
	private String priceRange;
	
	private List<ServiceProviders> serviceProviderList = new ArrayList<>();

}
