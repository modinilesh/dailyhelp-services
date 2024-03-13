package com.homecare.services.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	}
	@Override
	public ServiceListDto getServiceByName(String serviceName){
		
		ServiceList serviceLists=serviceListRepository.findByserviceName(serviceName);

		ServiceListDto serviceListDTOs=new ServiceListDto();
		serviceListDTOs=mapToDto(serviceLists);
		return  serviceListDTOs;
		
	}

	@Override
	public List<ServiceListDto> getServiceByType(String serviceType){
		
		List<ServiceList> serviceLists=serviceListRepository.findAllByserviceType(serviceType);

		List<ServiceListDto> serviceListDTOs=new ArrayList<>();
		for(ServiceList s: serviceLists){
			serviceListDTOs.add(mapToDto(s));
		}
		
		return  serviceListDTOs;
	}

	@Override
	public String deleteService(ServiceListDto serviceListDto){

		ServiceListDto serviceListDtoOld=new ServiceListDto();
		serviceListDtoOld=getServiceByName(serviceListDto.getServiceName());
		serviceListRepository.deleteById(serviceListDtoOld.getServiceId());
		return "Service deleted Successfully";
	}

	@Override
	public String deleteServiceById(Long serviceId){
		//ServiceListDto serviceListDto=new ServiceListDto();
		serviceListRepository.deleteById(serviceId);
		return "Service deleted Successfully with id = "+serviceId;
	}

	@Override
	public ServiceListDto updateServiceById(Long serviceId, ServiceListDto serviceListDto){
		ServiceList serviceListOld=serviceListRepository.findByServiceId(serviceId);
		
		serviceListOld.setPriceRange(serviceListDto.getPriceRange());
		serviceListOld.setServiceName(serviceListDto.getServiceName());
		serviceListOld.setServiceType(serviceListDto.getServiceType());
		//serviceListOld.setServiceProviderList(serviceListDto.getServiceProviderList());

		ServiceList savedService = serviceListRepository.save(serviceListOld);
		return mapToDto(savedService);

	}

	
	// public ServiceListDto updateService(ServiceListDto serviceListDto) {
	// 	// TODO Auto-generated method stub
		

	// 	ServiceListDto serviceListDtoOld=new ServiceListDto();
	// 	serviceListDtoOld=getServiceByName(serviceListDto.getServiceName());
	// 	//serviceListDtoOld=serviceListRepository.getReferenceById(serviceListDtoOld.getServiceId());
	// 	//ServiceList serviceList = mapToService(serviceListDtoOld);
	// 	Optional<ServiceList> serviceListTemp =serviceListRepository.findById(serviceListDtoOld.getServiceId());
    //     ServiceList serviceList=serviceListTemp.get();
	// 	serviceList.setPriceRange(serviceListDto.getPriceRange());
	// 	serviceList.setServiceName(serviceListDto.getServiceName());
	// 	serviceList.setServiceType(serviceListDto.getServiceType());
	// 	serviceList.setServiceProviderList(serviceListDto.getServiceProviderList());
	// 	// add object in DB
	// 	serviceListTemp=Optional.of(serviceList);
	// 	ServiceList savedService = serviceListRepository.save(serviceListTemp.get());

	// 	// map service to DTO
	// 	ServiceListDto responseService = mapToDto(savedService);
	// 	return serviceListDto;
	// 	//throw new UnsupportedOperationException("Unimplemented method 'updateService'");
	// }

	

}
