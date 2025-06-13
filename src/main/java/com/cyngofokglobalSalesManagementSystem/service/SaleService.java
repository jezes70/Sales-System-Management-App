package com.cyngofokglobalSalesManagementSystem.service;

import com.cyngofokglobalSalesManagementSystem.dto.SaleDTO;

import java.util.List;

public interface SaleService {

    List<SaleDTO> getAllSales();

    SaleDTO createSale(SaleDTO saleDTO);

    SaleDTO updateSale(Long id, SaleDTO saleDTO);

}
