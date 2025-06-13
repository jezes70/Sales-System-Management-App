package com.cyngofokglobalSalesManagementSystem.controller;

import com.cyngofokglobalSalesManagementSystem.dto.ReportDTO;
import com.cyngofokglobalSalesManagementSystem.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/sales")
    public ResponseEntity<ReportDTO> getSalesReport(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate startDate,
                                                    @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(reportService.generateSalesReport(startDate, endDate));
    }

    @GetMapping("/clients")
    public ResponseEntity<ReportDTO> getClientReport() {
        return ResponseEntity.ok(reportService.generateClientReport());
    }

    @GetMapping("/products")
    public ResponseEntity<ReportDTO> getProductReport() {
        return ResponseEntity.ok(reportService.generateProductReport());
    }
}
