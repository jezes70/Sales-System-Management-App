package com.cyngofokglobalSalesManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryStatusDTO {

    private int totalProducts;
    private int lowStockCount;
    private int outOfStockCount;
}
