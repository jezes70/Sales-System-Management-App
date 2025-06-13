package com.cyngofokglobalSalesManagementSystem.service.impl;

import com.cyngofokglobalSalesManagementSystem.dto.ReportDTO;
import com.cyngofokglobalSalesManagementSystem.repository.SaleRepository;
import com.cyngofokglobalSalesManagementSystem.service.ReportService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class ReportServiceImpl implements ReportService {

    private final SaleRepository saleRepository;

    ReportServiceImpl(SaleRepository saleRepository){
        this.saleRepository = saleRepository;
    }

    @Override
    public ReportDTO generateSalesReport(LocalDate startDate, LocalDate endDate) {
        var start = startDate.atStartOfDay();
        var end = endDate.atTime(23, 59,59);

        var sales = saleRepository.findAllByCreatedAtBetween(start, end);
        int totalSales = sales.size();
        BigDecimal totalRevenue = sales.stream()
                .map(sale -> sale.getTotal() == null ? BigDecimal.ZERO : sale.getTotal())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return ReportDTO.builder()
                .totalSales(totalSales)
                .totalRevenue(totalRevenue)
                .build();
    }

    @Override
    public ReportDTO generateClientReport() {
        return ReportDTO.builder()
                .totalSales(0)
                .totalRevenue(BigDecimal.ZERO)
                .build();
    }

    @Override
    public ReportDTO generateProductReport() {
        return ReportDTO.builder()
                .totalRevenue(BigDecimal.ZERO)
                .totalSales(0)
                .build();
    }
}
