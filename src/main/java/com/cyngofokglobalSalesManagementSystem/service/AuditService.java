package com.cyngofokglobalSalesManagementSystem.service;

public interface AuditService {

    void logAction(String entityType, Long entityId, String action, String performedBy, String details);
}
