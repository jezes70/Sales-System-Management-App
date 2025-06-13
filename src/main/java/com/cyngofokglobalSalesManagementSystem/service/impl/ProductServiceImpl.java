package com.cyngofokglobalSalesManagementSystem.service.impl;

import com.cyngofokglobalSalesManagementSystem.dto.ProductDTO;
import com.cyngofokglobalSalesManagementSystem.entity.Product;
import com.cyngofokglobalSalesManagementSystem.exception.ResourceNotFoundException;
import com.cyngofokglobalSalesManagementSystem.repository.ProductRepository;
import com.cyngofokglobalSalesManagementSystem.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository,
                              ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        Product saved = productRepository.save(product);
        return modelMapper.map(saved, ProductDTO.class);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        modelMapper.map(productDTO, existing);
        Product updated = productRepository.save(existing);
        return modelMapper.map(updated, ProductDTO.class);

    }

    @Override
    public void deleteProduct(Long id) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        productRepository.delete(existing);
    }
}
