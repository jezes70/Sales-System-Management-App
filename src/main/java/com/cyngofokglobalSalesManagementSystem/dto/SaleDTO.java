package com.cyngofokglobalSalesManagementSystem.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleDTO {

    private Long id;

    private LocalDateTime createdAt;
    @NotBlank(message = "Client ID is required")
    private Long clientId;
    @NotBlank(message = "Seller ID is required")
    private Long sellerId;

    private BigDecimal total;
    @NotBlank(message = "Sale items are required")
    private List<SaleItemDTO> saleItems;
}

