package com.homecare.services.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homecare.services.entities.ServiceList;
import com.homecare.services.payload.ServiceListDto;
import com.homecare.services.repository.ServiceListRepository;
import com.homecare.services.service.ServicesListService;

@Service
public class ServicesListServiceImpl implements ServicesListService {

	@Autowired
	private ServiceListRepository serviceListRepository;



	//Create Service
	@Override
	public ServiceListDto createService(ServiceListDto serviceListDto) {

		// get service object
		ServiceList serviceList = mapToService(serviceListDto);

		// add object in DB
		ServiceList savedService = serviceListRepository.save(serviceList);

		// map service to DTO
		ServiceListDto responseService = mapToDto(savedService);

		return responseService;

	}







	public ServiceList mapToService(ServiceListDto serviceListDto) {

		ServiceList serviceList = new ServiceList();

		// mapping fields
		serviceList.setServiceName(serviceListDto.getServiceName());
		serviceList.setServiceType(serviceListDto.getServiceType());
		serviceList.setPriceRange(serviceListDto.getPriceRange());

		return serviceList;
	}
 
	public ServiceListDto mapToDto(ServiceList serviceList) {
 
		ServiceListDto serviceListDto = new ServiceListDto();

		// mapping fields
		serviceListDto.setServiceId(serviceList.getServiceId());
		serviceListDto.setServiceName(serviceList.getServiceName());
		serviceListDto.setServiceType(serviceList.getServiceType());
		serviceListDto.setPriceRange(serviceList.getPriceRange());

		return serviceListDto;
	}







	@Override
	public List<ServiceListDto> getAllServices() {
		// TODO Auto-generated method stub
		List<ServiceList> serviceList=new ArrayList<>();
		serviceList=serviceListRepository.findAll();
		List<ServiceListDto> serviceListDTOs=new ArrayList<>();
		for(ServiceList s: serviceList){
			serviceListDTOs.add(mapToDto(s));
		}
		return serviceListDTOs;
		//throw new UnsupportedOperationException("Unimplemented method 'getAllServices'");
	}
	@Override
	public ServiceListDto getServiceByName(String name){
		List<ServiceList> serviceList=new ArrayList<>();
		serviceList=serviceListRepository.findAll();
		ServiceListDto serviceListDTOs=new ServiceListDto();
		//String ans=null;
		for(ServiceList s: serviceList){
			if(name.equals(s.getServiceName())){
				serviceListDTOs=mapToDto(s);
				return serviceListDTOs;
			}
		}

		return serviceListDTOs;

	}

	

}
