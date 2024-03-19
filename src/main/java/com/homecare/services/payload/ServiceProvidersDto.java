package com.homecare.services.payload;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.homecare.services.entities.Address;
import com.homecare.services.entities.Rating;
import com.homecare.services.entities.ServiceList;

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
public class ServiceProvidersDto {
	
	private Long providerId;
	
	private String providerName;
	
	private int providerAge;
	
	private Address providerAddress;
	
	private Long aadharNumber;
	
	private Long contactNumber;
	
	private int providerFee;
	
	private int providerExperience;
	
	private ServiceList serviceId;
	
	private List<Rating> providerRating = new ArrayList<>();

}
