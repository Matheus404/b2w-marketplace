package com.marketplace.b2w.service;

import com.marketplace.b2w.model.Dimension;
import com.marketplace.b2w.model.Product;
import com.marketplace.b2w.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;

    @Test
    void whenICallThSaveProductsServiceItReturnsVoid() {

        productService.saveResponse();

        assertEquals(productRepository.findAll().size(), 13);
    }

    @Test
    void whenIReceiveTwoDatesIMustShowTheProductsRegisteredBetweenThem() {

        List<Product> productsMock = productsMock();

        String startDate = "01-10-2016";
        String endDate = "03-10-2016";

        List<Product> productsResult = productService.betweenDates(startDate, endDate);

        assertEquals(productsMock, productsResult);

    }

    List<Product> productsMock() {

        List<Product> products = new ArrayList<>();

        Dimension dimension = Dimension.builder()
                .weight(10.5)
                .height(10.5)
                .width(10.5)
                .length(10.5)
                .build();

        products.add(Product.builder()
                .name("Celular")
                .code(1L)
                .date("2016-10-01T14:30:37.040Z")
                .dimension(dimension)
                .build());

        products.add(Product.builder()
                .name("Xbox")
                .code(2L)
                .date("2016-10-02T14:30:37.040Z")
                .dimension(dimension)
                .build());

        products.add(Product.builder()
                .name("Televisao")
                .code(3L)
                .date("2016-10-03T14:30:37.040Z")
                .dimension(dimension)
                .build());

        return products;
    }

}
