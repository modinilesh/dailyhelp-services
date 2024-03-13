package com.homecare.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homecare.services.entities.ServiceList;

public interface ServiceListRepository extends JpaRepository<ServiceList, Long> {

    //humko jo bhi find by karna hai, hum us column ka name use karenge method name me name ki koi generic name
    // jaise hame serviceName se filter karna tha to humne method name rakha- findBy+column Name i.e serviceName
     ServiceList findByserviceName(String serviceName);
     List<ServiceList> findAllByserviceType(String serviceType);
     ServiceList findByServiceId(Long serviceId);
}
