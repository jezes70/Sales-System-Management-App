package com.cyngofokglobalSalesManagementSystem.service;

import com.cyngofokglobalSalesManagementSystem.entity.SaleItem;
import com.cyngofokglobalSalesManagementSystem.exception.ResourceNotFoundException;
import com.cyngofokglobalSalesManagementSystem.repository.SaleItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleItemService {

    private final SaleItemRepository saleItemRepository;

    SaleItemService(SaleItemRepository saleItemRepository) {
        this.saleItemRepository = saleItemRepository;
    }

    public SaleItem getItemById(Long id) {
        return saleItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sale item not found"));
    }

    public SaleItem saveItem(SaleItem item) {
        return saleItemRepository.save(item);
    }

    public void deleteItem(Long id) {
        saleItemRepository.deleteById(id);
    }

    public List<SaleItem> getAllItems() {
        return saleItemRepository.findAll();
    }

    public List<SaleItem> getItemByProductId(Long productId) {
        return saleItemRepository.findByProductId(productId);
    }
}
