package com.marketplace.b2w.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marketplace.b2w.model.Product;
import com.marketplace.b2w.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    public void saveResponse() {
        List<Product> objectList = new ArrayList<>();
        String url = "http://www.mocky.io/v2/5817803a1000007d01cc7fc9";
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                ObjectMapper mapper = new ObjectMapper();
                try {
                    objectList = mapper.readValue(response.getBody(), new TypeReference<>() {
                    });
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            log.error(e.getMessage());
        }

        productRepository.saveAll(objectList);
    }

    public List<Product> betweenDates(String startDate, String endDate) {

        saveResponse();

        startDate += " 00:00:00.000";
        endDate += " 23:59:59.999";

        DateTimeFormatter formatterInput = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS");
        DateTimeFormatter formatterOutput = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SS");

        LocalDateTime localDateTime = LocalDateTime.parse(startDate, formatterInput);
        LocalDateTime localDateTime2 = LocalDateTime.parse(endDate, formatterInput).plusDays(1);

        String startDateOutput = formatterOutput.format(localDateTime);
        String endDateOutput = formatterOutput.format(localDateTime2);

        return productRepository.findByDateBetween(startDateOutput, endDateOutput);
    }

}
