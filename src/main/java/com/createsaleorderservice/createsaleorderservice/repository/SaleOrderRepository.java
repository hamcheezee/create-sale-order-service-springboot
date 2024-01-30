package com.createsaleorderservice.createsaleorderservice.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.createsaleorderservice.createsaleorderservice.model.SaleOrder;

public interface SaleOrderRepository extends JpaRepository<SaleOrder, Integer> {
    
    // check order status
    @Query(nativeQuery = true, value = "SELECT * FROM createsaleorderservice.saleorder WHERE (order_status = 'Completed') OR (order_status = 'In progress')")
    List<SaleOrder> checkOrderStatus();

}
