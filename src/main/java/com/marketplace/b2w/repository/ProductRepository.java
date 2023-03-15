package com.marketplace.b2w.repository;

import com.marketplace.b2w.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByDateBetween(String startDate, String endDate);

}
