package com.homecare.services.entities;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@OneToOne(mappedBy = "providerAddress", orphanRemoval = true, cascade = CascadeType.ALL)
	private Long addressId;
	
	@Column(name = "line1", nullable = false)
	private String line1;
	
	@Column(name = "line2")
	private String line2;
	
	@Column(name = "city", nullable = false)
	private String city;

	@Column(name = "cityPincode", nullable = false)
	private int cityPincode;
	
	@Column(name = "state", nullable = false)
	private String state;
	
	@Column(name = "country", nullable = false)
	private String country;

}
