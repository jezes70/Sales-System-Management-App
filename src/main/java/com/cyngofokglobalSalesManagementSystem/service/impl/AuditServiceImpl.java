package com.cyngofokglobalSalesManagementSystem.service.impl;

import com.cyngofokglobalSalesManagementSystem.entity.AuditLog;
import com.cyngofokglobalSalesManagementSystem.repository.AuditLogRepository;
import com.cyngofokglobalSalesManagementSystem.service.AuditService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditServiceImpl implements AuditService {

    private final AuditLogRepository auditLogRepository;

   public AuditServiceImpl(AuditLogRepository auditLogRepository) {
       this.auditLogRepository = auditLogRepository;
   }

    @Override
    public void logAction(String entityType, Long entityId, String action, String performedBy, String details) {
        AuditLog log = AuditLog.builder()
                .entityType(entityType)
                .entityId(entityId)
                .action(action)
                .performedBy(performedBy)
                .timestamp(LocalDateTime.now())
                .details(details)
                .build();
        auditLogRepository.save(log);
    }
}
