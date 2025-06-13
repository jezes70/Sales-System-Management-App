package com.cyngofokglobalSalesManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientLocationStatsDTO {

    private Map<String, Integer> clientsByCity;
}
