package com.mawulidev.partfour.repository;

import com.mawulidev.partfour.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private final List<Product> productList = new ArrayList<>();
    private Long nextId = 1L;

    /**
     * Get all users.
     */
    @Override
    public List<Product> findAll() {
        return productList;
    }

    /**
     * Retrieve a product by their ID.
     */
    @Override
    public Optional<Product> findById(Long id) {
        return productList.stream().filter(product -> Objects.equals(product.getId(), id)).findFirst();
    }

    /**
     * Create a new product and add to the in-memory List.
     */
    @Override
    public void save(Product product) {
        product.setId(nextId++);
        productList.add(product);
    }

    /**
     * Update an existing product by their ID.
     */
    @Override
    public void update(Product product, Long id) {
        findById(id).ifPresent(existingProduct -> {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
        });
    }

    /**
     * Delete a product by their ID.
     */
    @Override
    public void deleteById(Long id) {
        productList.removeIf(product -> product.getId() == id);
    }
}
