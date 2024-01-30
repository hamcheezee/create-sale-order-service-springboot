package com.createsaleorderservice.createsaleorderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createsaleorderservice.createsaleorderservice.repository.SaleOrderRepository;
import com.createsaleorderservice.createsaleorderservice.model.SaleOrder;

@Service
public class SaleOrderService {

    @Autowired
    private SaleOrderRepository saleOrderRepository;

    public List<SaleOrder> listAllSaleOrders() 
    {
        return saleOrderRepository.findAll();
    }

    public void saveSaleOrder(SaleOrder saleOrder) 
    {
        saleOrderRepository.save(saleOrder);
    }

    public SaleOrder getSaleOrderByID(Integer id) 
    {
        return saleOrderRepository.findById(id).get();
    }

    public void deleteSaleOrder(Integer id) 
    {
        saleOrderRepository.deleteById(id);
    }

    public List<SaleOrder> checkOrderStatus() 
    {
        return saleOrderRepository.checkOrderStatus();
    }
    
}
