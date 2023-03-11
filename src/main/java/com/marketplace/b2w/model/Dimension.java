package com.marketplace.b2w.model;

import javax.persistence.Embeddable;

import lombok.*;


@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class Dimension {
	
	private double weight;
	
	private double height;
	
	private double width;
	
	private double length;
	
}
