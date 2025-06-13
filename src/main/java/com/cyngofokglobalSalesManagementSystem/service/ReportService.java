package com.cyngofokglobalSalesManagementSystem.service;

import com.cyngofokglobalSalesManagementSystem.dto.ReportDTO;

import java.time.LocalDate;

public interface ReportService {

    ReportDTO generateSalesReport(LocalDate startDate, LocalDate endDate);

    ReportDTO generateClientReport();

    ReportDTO generateProductReport();
}
