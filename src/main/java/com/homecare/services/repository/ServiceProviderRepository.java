package com.homecare.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homecare.services.entities.ServiceProviders;

public interface ServiceProviderRepository extends JpaRepository<ServiceProviders, Long> {

}
