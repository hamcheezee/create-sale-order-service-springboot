package com.createsaleorderservice.createsaleorderservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchaseorder")
public class PurchaseOrder {
    
    @Id
    @Column(name = "purchase_order_number")
    private int purchase_order_number;

    @Column(name = "order_number")
    private int order_number;

    @Column(name = "purchase_order_date")
    private String purchase_order_date;

    @Column(name = "delivery_date")
    private String delivery_date;

    @Column(name = "order_status")
    private String order_status;

    @Column(name = "material_code")
    private String material_code;

    @Column(name = "material_name")
    private String material_name;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unit_cost")
    private float unit_cost;

    @Column(name = "subtotal")
    private float subtotal;

    @Column(name = "tax")
    private float tax;

    @Column(name = "total_net_price")
    private float total_net_price;

    @Column(name = "billing_address")
    private String billing_address;

    @Column(name = "shipping_address")
    private String shipping_address;

    public PurchaseOrder() {
        
    }

    public PurchaseOrder(int purchase_order_number, int order_number, String purchase_order_date, String delivery_date,
            String order_status, String material_code, String material_name, int quantity, float unit_cost,
            float subtotal, float tax, float total_net_price, String billing_address, String shipping_address) {
        this.purchase_order_number = purchase_order_number;
        this.order_number = order_number;
        this.purchase_order_date = purchase_order_date;
        this.delivery_date = delivery_date;
        this.order_status = order_status;
        this.material_code = material_code;
        this.material_name = material_name;
        this.quantity = quantity;
        this.unit_cost = unit_cost;
        this.subtotal = subtotal;
        this.tax = tax;
        this.total_net_price = total_net_price;
        this.billing_address = billing_address;
        this.shipping_address = shipping_address;
    }

    public int getPurchase_order_number() {
        return purchase_order_number;
    }

    public void setPurchase_order_number(int purchase_order_number) {
        this.purchase_order_number = purchase_order_number;
    }

    public int getOrder_number() {
        return order_number;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }

    public String getPurchase_order_date() {
        return purchase_order_date;
    }

    public void setPurchase_order_date(String purchase_order_date) {
        this.purchase_order_date = purchase_order_date;
    }

    public String getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getMaterial_code() {
        return material_code;
    }

    public void setMaterial_code(String material_code) {
        this.material_code = material_code;
    }

    public String getMaterial_name() {
        return material_name;
    }

    public void setMaterial_name(String material_name) {
        this.material_name = material_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnit_cost() {
        return unit_cost;
    }

    public void setUnit_cost(float unit_cost) {
        this.unit_cost = unit_cost;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public float getTotal_net_price() {
        return total_net_price;
    }

    public void setTotal_net_price(float total_net_price) {
        this.total_net_price = total_net_price;
    }

    public String getBilling_address() {
        return billing_address;
    }

    public void setBilling_address(String billing_address) {
        this.billing_address = billing_address;
    }

    public String getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(String shipping_address) {
        this.shipping_address = shipping_address;
    }

}