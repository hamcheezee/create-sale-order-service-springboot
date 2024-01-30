package com.createsaleorderservice.createsaleorderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createsaleorderservice.createsaleorderservice.model.PurchaseOrder;
import com.createsaleorderservice.createsaleorderservice.repository.PurchaseOrderRepository;

@Service
public class PurchaseOrderService {
  
    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    public List<PurchaseOrder> listAllPurchaseOrders() 
    {
        return purchaseOrderRepository.findAll();
    }

    public PurchaseOrder getPurchaseOrderByPurchaseNumberOrder(Integer purchase_order_number) 
    {
        return purchaseOrderRepository.findById(purchase_order_number).get();
    }

}
