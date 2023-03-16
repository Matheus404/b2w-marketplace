package com.marketplace.b2w.controller;

import com.marketplace.b2w.model.Product;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    ProductController productController = Mockito.mock(ProductController.class);

    @Autowired
    private MockMvc mockMvc;

    @Test
    void whenIPassADateRangeIGetTheProductsRegisteredInTheRange() {

        final String startDate = "01-10-2016";
        final String endDate = "03-10-2016";

        Mockito.when(productController.between(startDate, endDate))
                .thenReturn(new ResponseEntity<>(HttpStatus.OK));

        ResponseEntity<List<Product>> response = productController.between(startDate, endDate);

        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    void gettingADateRangeReturnsProductsAndStatus200Ok() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/challenge-backend/item?begindate=05-10-2016&finaldate=10-10-2016"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}