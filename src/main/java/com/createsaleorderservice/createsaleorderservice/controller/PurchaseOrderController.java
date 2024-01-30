package com.createsaleorderservice.createsaleorderservice.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createsaleorderservice.createsaleorderservice.model.PurchaseOrder;
import com.createsaleorderservice.createsaleorderservice.service.PurchaseOrderService;

@RestController
@RequestMapping("/api")
public class PurchaseOrderController {
    
    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @GetMapping("/get-all-purchaseorders")
    public List<PurchaseOrder> getAllPurchaseOrders() 
    {
        System.out.println("Get All Purchase Orders Successfully!!");
        return purchaseOrderService.listAllPurchaseOrders();
    }

    @GetMapping("/get-purchaseorder-by-purchase_order_number/{purchase_order_number}")
    public ResponseEntity<?> getSaleOrderByID(@PathVariable Integer purchase_order_number)
    {
        try {
            PurchaseOrder purchaseOrder = purchaseOrderService.getPurchaseOrderByPurchaseNumberOrder(purchase_order_number);
            System.out.println("Search a Purchase Order by ID Successfully!!");
            return new ResponseEntity<PurchaseOrder>(purchaseOrder, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<PurchaseOrder>(HttpStatus.NOT_FOUND);
        }
    }

}
