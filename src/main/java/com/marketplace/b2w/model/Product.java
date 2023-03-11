package com.marketplace.b2w.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Objects;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Builder
@Table(name = "PRODUCT")
public class Product {
	
	@Id
	private Long code;
	
	private String name;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
	private String date;
	
    @CollectionTable(
            name="DIMENSION",
            joinColumns = @JoinColumn(name = "PRODUCT_CODE")
    )
	private Dimension dimension;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return Objects.equals(name, product.name) && Objects.equals(date, product.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, date);
	}
}
