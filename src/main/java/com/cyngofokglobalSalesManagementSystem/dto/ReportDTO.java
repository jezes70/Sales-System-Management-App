package com.cyngofokglobalSalesManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportDTO {

    private int totalSales;
    private BigDecimal totalRevenue;
    private List<TopSellingProductDTO> topSellingProducts;
    private List<TopClientDTO> topClients;
    private List<TopSellingDTO> topSellers;

    private InventoryStatusDTO inventoryStatus;
    private PricingAnalysisDTO pricingAnalysis;
    private ClientLocationStatsDTO clientLocationStats;
}
