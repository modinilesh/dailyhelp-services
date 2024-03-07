package com.homecare.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homecare.services.entities.ServiceList;

public interface ServiceListRepository extends JpaRepository<ServiceList, Long> {

}
