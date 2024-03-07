package com.homecare.services.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "service_providers", 
	   uniqueConstraints = {@UniqueConstraint(columnNames = {"aadharNumber", "contactNumber"})})		
public class ServiceProviders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long providerId;
	
	@Column(name = "providerName", nullable = false)
	private String providerName;
	
	@Column(name = "providerAge", nullable = false)
	private int providerAge;
	
	@JoinColumn(name = "providerAddress", referencedColumnName = "addressId", nullable = false)
	@OneToOne(cascade = CascadeType.ALL)
	private Address providerAddress;
	
	@Column(name = "aadharNumber", nullable = false)
	private Long aadharNumber;
	
	@Column(name = "contactNumber", nullable = false)
	private Long contactNumber;
	
	
	//one service provider can have multiple mappings
	@OneToMany(mappedBy = "providersId", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Rating> providerRating = new ArrayList<>();
	
	@Column(name = "providerFee", nullable = false)
	private int providerFee;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "servicesId", nullable = false)
	private ServiceList servicesId;
	
//	private Long jobsCompleted;
	
	@Column(name = "providerExperience", nullable = false)
	private int providerExperience;
	
	

}
