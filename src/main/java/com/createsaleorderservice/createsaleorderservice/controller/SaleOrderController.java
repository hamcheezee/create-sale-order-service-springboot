package com.createsaleorderservice.createsaleorderservice.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createsaleorderservice.createsaleorderservice.service.SaleOrderService;
import com.createsaleorderservice.createsaleorderservice.model.SaleOrder;

@RestController
@RequestMapping("/api")
public class SaleOrderController {
    
    @Autowired
    private SaleOrderService saleOrderService;

    @PostMapping("/create-saleorder")
    public String createSaleorder(@RequestBody SaleOrder saleOrder)
    {
        saleOrderService.saveSaleOrder(saleOrder);
        return "Create a Sale Order Success!!";
    }

    @GetMapping("/get-all-saleorders")
    public List<SaleOrder> getAllSaleOrders() 
    {
        System.out.println("Get All Sale Orders Successfully!!");
        return saleOrderService.listAllSaleOrders();
    }

    @GetMapping("/get-saleorder-by-id/{id}")
    public ResponseEntity<?> getSaleOrderByID(@PathVariable Integer id)
    {
        try {
            SaleOrder saleOrder = saleOrderService.getSaleOrderByID(id);
            System.out.println("Search a Sale Order by ID Successfully!!");
            return new ResponseEntity<SaleOrder>(saleOrder, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<SaleOrder>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update-saleorder/{id}")
    public ResponseEntity<?> updateSaleorder(@RequestBody SaleOrder saleOrder, @PathVariable Integer id) {
        try {
            // SaleOrder existSaleOrder = saleOrderService.getSaleOrderByID(id);
            saleOrder.setSaleorder_id(id);
            saleOrderService.saveSaleOrder(saleOrder);;
			System.out.println("Update a Sale Order Successfully!");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@DeleteMapping("/delete-saleorder/{id}")
    public String delete(@PathVariable Integer id) {
		saleOrderService.deleteSaleOrder(id);;
		System.out.println("Delete a Sale Order Successfully!");
		return "Delete a Sale Order Success!!"; 
    }

    // @GetMapping("/check-confirmed-order/{order_status}")
    // public List<SaleOrder> checkOrderStatus(@PathVariable("order_status") String order_status) 
    // {
    //     System.out.println("Check Confirmed Order Successfully!!");
    //     return saleOrderService.checkOrderStatus(order_status);
    // }

    @GetMapping("/check-confirmed-order")
    public List<SaleOrder> checkOrderStatus() 
    {
        System.out.println("Check Confirmed Order Successfully!!");
        return saleOrderService.checkOrderStatus();
    }

}
