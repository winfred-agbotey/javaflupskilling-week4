package com.mawulidev.partfour.service;

import com.mawulidev.partfour.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();

    ProductDTO findById(Long id);

    String save(ProductDTO productDTO);

    String update(ProductDTO productDTO, Long id);

    String deleteById(Long id);
}
