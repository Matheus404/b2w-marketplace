package com.marketplace.b2w.controller;

import com.marketplace.b2w.model.Product;
import com.marketplace.b2w.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/")
public class ProductController {
    private ProductService productService;
    @GetMapping("challenge-backend/item")
    public ResponseEntity<List<Product>> between(@RequestParam String begindate, @RequestParam String finaldate) {
        try {
            return ResponseEntity.ok().body(productService.betweenDates(begindate, finaldate));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
