package com.mawulidev.partfour.repository;

import com.mawulidev.partfour.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();

    Optional<Product> findById(Long id);

    void save(Product product);

    void update(Product product,Long id);

    void deleteById(Long id);
}
