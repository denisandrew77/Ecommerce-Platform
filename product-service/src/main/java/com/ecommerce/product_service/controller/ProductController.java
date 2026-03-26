package com.ecommerce.product_service.controller;

import com.ecommerce.product_service.dto.ProductDto;
import com.ecommerce.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product/create")
    public ResponseEntity<String> save(@RequestBody ProductDto product) {
        if(productService.addNewProduct(product)){
            return new ResponseEntity<>("Product Created", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Product Not Created", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/product/{productName}/verifyAvailability/{requestedQuantity}")
    public ResponseEntity<String> verifyAvailability(@PathVariable String productName, @PathVariable Integer requestedQuantity) {
        if(productService.verifyProductAndAvailableQuantity(productName, requestedQuantity)){
            return new ResponseEntity<>("Product:"+ productName +" is available", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Product:"+ productName +" is not available", HttpStatus.BAD_REQUEST);
        }
    }
}
