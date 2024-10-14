package com.mawulidev.partfour.controller;

import com.mawulidev.partfour.dto.ProductDTO;
import com.mawulidev.partfour.dto.ResponseHandler;
import com.mawulidev.partfour.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<Object> getAllProducts() {
        return ResponseHandler.successResponse(HttpStatus.OK, productService.findAll());
    }

    // Get product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Long id) {
        return ResponseHandler.successResponse(HttpStatus.OK, productService.findById(id));
    }

    // Add a new product
    @PostMapping
    public ResponseEntity<Object> addProduct(@Valid @RequestBody ProductDTO product) {
        productService.save(product);
        return ResponseHandler.successResponse(HttpStatus.CREATED, productService.save(product));
    }

    // Update an existing product
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@Valid
            @RequestBody ProductDTO product, @PathVariable Long id) {
        return ResponseHandler.successResponse(HttpStatus.OK, productService.update(product, id));
    }

    // Delete a product
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {

        return ResponseHandler.successResponse(HttpStatus.OK, productService.deleteById(id));
    }
}
