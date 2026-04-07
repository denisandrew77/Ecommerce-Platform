package com.ecommerce.product_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.product_service.dto.ProductDto;
import com.ecommerce.product_service.dto.responseEntity.ProductState;
import com.ecommerce.product_service.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product/create")
    public ResponseEntity<ProductState> save(@RequestBody ProductDto product) {
        if(productService.addNewProduct(product)){
            ProductState state = new ProductState(true, product.getName()+" has been created");
            return new ResponseEntity<>(state, HttpStatus.CREATED);
        }else{
            ProductState state = new ProductState(false, product.getName()+" has already been created");
            return new ResponseEntity<>(state, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/product/{productName}/verifyAvailability/{requestedQuantity}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable String productName, @PathVariable Integer requestedQuantity) {
        productService.verifyProductAndAvailableQuantity(productName, requestedQuantity);
        return new ResponseEntity<>(productService.getProductByName(productName), HttpStatus.OK);
    }

    @PostMapping("/product/{productName}/updateQuantity/{requestedQuantity}")
    public ResponseEntity<ProductState> updateQuantity(@PathVariable String productName, @PathVariable Integer requestedQuantity) {
        productService.updateProductQuantity(productName, requestedQuantity);
        return new ResponseEntity<>(new ProductState(true, productName+" has been updated"), HttpStatus.OK);
    }
}
