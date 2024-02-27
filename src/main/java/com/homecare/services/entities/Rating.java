package com.homecare.services.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ratings")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ratingId;
	
	@Column(name = "ratingScore", nullable = false)
	private int ratingScore;
	
	@Column(name = "reviewComment", nullable = false)
	private String reviewComment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "providersId", nullable = false)
	private ServiceProviders providersId;
	
	

}
