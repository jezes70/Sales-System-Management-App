package com.cyngofokglobalSalesManagementSystem.service.impl;

import com.cyngofokglobalSalesManagementSystem.dto.SaleDTO;
import com.cyngofokglobalSalesManagementSystem.dto.SaleItemDTO;
import com.cyngofokglobalSalesManagementSystem.entity.Sale;
import com.cyngofokglobalSalesManagementSystem.entity.SaleItem;
import com.cyngofokglobalSalesManagementSystem.exception.ResourceNotFoundException;
import com.cyngofokglobalSalesManagementSystem.repository.SaleRepository;
import com.cyngofokglobalSalesManagementSystem.service.SaleService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;

    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public List<SaleDTO> getAllSales() {
        return saleRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SaleDTO createSale(SaleDTO saleDTO) {
        Sale sale = mapToEntity(saleDTO);
        sale.setCreatedAt(LocalDateTime.now());

        BigDecimal total = sale.getSaleItems().stream()
                .map(SaleItem -> SaleItem.getPrices().multiply(BigDecimal.valueOf(SaleItem.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        sale.setTotal(total);

        Sale saved = saleRepository.save(sale);
        return mapToDTO(saved);
    }

    @Override
    public SaleDTO updateSale(Long id, SaleDTO saleDTO) {
        Sale existing = saleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sale not found with id: " + id));

        existing.setClientId(saleDTO.getClientId());
        existing.setSellerId(saleDTO.getSellerId());
        existing.setSaleItems(saleDTO.getSaleItems().stream().map(this::mapToItemEntity).collect(Collectors.toList()));

        BigDecimal total = existing.getSaleItems().stream()
                .map(SaleItem -> SaleItem.getPrices().multiply(BigDecimal.valueOf(SaleItem.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        existing.setTotal(total);

        Sale updated = saleRepository.save(existing);
        return mapToDTO(updated);
    }

    private SaleDTO mapToDTO(Sale sale) {
        return SaleDTO.builder()
                .id(sale.getId())
                .clientId(sale.getClient().getId())
                .sellerId(sale.getSeller().getId())
                .createdAt(sale.getCreatedAt())
                .total(sale.getTotal())
                .saleItems(sale.getSaleItems().stream()
                        .map(saleItem -> SaleItemDTO.builder()
                                .productId(saleItem.getProduct().getId())
                                .price(saleItem.getPrices())
                                .quantity(saleItem.getQuantity())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    private Sale mapToEntity(SaleDTO dto) {
        Sale sale = new Sale();
        sale.setClientId(dto.getClientId());
        sale.setSellerId(dto.getSellerId());
        sale.setSaleItems(dto.getSaleItems().stream()
                .map(this::mapToItemEntity)
                .collect(Collectors.toList()));
        return sale;
    }

    private SaleItem mapToItemEntity(SaleItemDTO dto) {
        SaleItem item = new SaleItem();
        item.setProductId(dto.getProductId());
        item.setPrices(dto.getPrice());
        item.setQuantity(dto.getQuantity());

        return item;
    }
}
