package com.cyngofokglobalSalesManagementSystem.controller;

import com.cyngofokglobalSalesManagementSystem.dto.SaleDTO;
import com.cyngofokglobalSalesManagementSystem.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sales")
public class SalesController {

    private final SaleService saleService;

    @GetMapping
    public ResponseEntity<List<SaleDTO>> getAllSales() {
        return ResponseEntity.ok(saleService.getAllSales());
    }

    @PostMapping
    public ResponseEntity<SaleDTO> createSale(@Validated @RequestBody SaleDTO saleDTO) {
        return ResponseEntity.ok(saleService.createSale(saleDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaleDTO> updateSale(@PathVariable Long id, @Validated @RequestBody SaleDTO saleDTO) {
        return ResponseEntity.ok(saleService.updateSale(id, saleDTO));
    }

}
