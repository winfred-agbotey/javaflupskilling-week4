package com.mawulidev.partfour.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mawulidev.partfour.dto.ProductDTO;
import com.mawulidev.partfour.exception.ProductNotFoundException;
import com.mawulidev.partfour.model.Product;
import com.mawulidev.partfour.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ObjectMapper mapper;

    /**
     * Get all products.
     */
    @Override
    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> mapper.convertValue(product, ProductDTO.class)).toList();
    }

    /**
     * Retrieve a product by their ID.
     */
    @Override
    public ProductDTO findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ProductNotFoundException("Product with the id " + id + " not found");
        }
        return mapper.convertValue(product.get(), ProductDTO.class);
    }


    /**
     * Create a new product and add to the in-memory List.
     */
    @Override
    public String save(ProductDTO productDTO) {
        Product product = mapper.convertValue(productDTO, Product.class);
        productRepository.save(product);
        return "Product created successfully";
    }

    /**
     * Update an existing product by their ID.
     */
    @Override
    public String update(ProductDTO productDTO, Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ProductNotFoundException("Product with the id " + id + " not found");
        }
        Product product1 = mapper.convertValue(productDTO, Product.class);
        productRepository.update(product1, id);
        return "Product updated successfully";
    }

    /**
     * Delete a product by their ID.
     */
    @Override
    public String deleteById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ProductNotFoundException("Product with the id " + id + " not found");
        }
        productRepository.deleteById(id);
        return "Product deleted successfully";
    }


}
