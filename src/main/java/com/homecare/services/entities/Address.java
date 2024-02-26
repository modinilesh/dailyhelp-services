package com.homecare.services.entities;

import jakarta.persistence.Column;
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
public class Address {
	
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
