package com.cyngofokglobalSalesManagementSystem.repository;

import com.cyngofokglobalSalesManagementSystem.entity.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {

    List<SaleItem> findByProductId(Long productId);
}
