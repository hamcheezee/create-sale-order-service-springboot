package com.createsaleorderservice.createsaleorderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.createsaleorderservice.createsaleorderservice.model.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Integer> {
    
}
