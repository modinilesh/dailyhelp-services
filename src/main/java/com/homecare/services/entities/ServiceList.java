package com.homecare.services.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table( name = "service_list", 
		uniqueConstraints = {@UniqueConstraint(columnNames = {"service_name"})}
	   )
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ServiceList {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long serviceId;
	
	@Column(name = "serviceName", nullable = false)
	private String serviceName;
	
	@Column(name = "serviceType", nullable = false)
	private String serviceType;
	
	@Column(name = "priceRange")
	private String priceRange;
	
	@OneToMany(mappedBy = "servicesId", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<ServiceProviders> serviceProviderList = new ArrayList<>();

}
