package com.ecommerce.product_service.service;

import com.ecommerce.product_service.dto.ProductDto;
import com.ecommerce.product_service.entity.Product;
import com.ecommerce.product_service.exceptionHandling.exception.LowQuantityException;
import com.ecommerce.product_service.exceptionHandling.exception.ProductAlreadyExistsException;
import com.ecommerce.product_service.exceptionHandling.exception.ProductNotFoundException;
import com.ecommerce.product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public boolean addNewProduct(ProductDto productDto) {
        Product product = new Product(productDto.getName(), productDto.getCategory(), productDto.getDescription(), productDto.getPrice(), productDto.getAvailableQuantity());
        if(productRepository.findByName(product.getName()).isPresent()) {
            throw new ProductAlreadyExistsException("Product "+ productDto.getName()+" already exists");
        }
        else  {
            productRepository.save(product);
            return true;
        }
    }

    public boolean verifyProductAndAvailableQuantity(String productName, Integer requestedQuantity) {
        Optional<Product> product = productRepository.findByName(productName);
        if(product.isPresent()) {
            if(product.get().getAvailableQuantity() >= requestedQuantity) {
                return true;
            }
            else {
                throw new LowQuantityException("Low quantity");
            }
        }
        else throw new ProductNotFoundException("Product not found");
    }
}
