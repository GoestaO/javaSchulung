/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goesta.model;

/**
 *
 * @author daniel
 */
public class ZalandoAPIUnits {

    private String id;
    private String size;
    private ZalandoAPIPrice price;
    private ZalandoAPIPrice originalPrice;
    private boolean available;
    private int stock;

    public ZalandoAPIPrice getPrice() {
        return price;
    }

    public void setPrice(ZalandoAPIPrice price) {
        this.price = price;
    }

    public ZalandoAPIPrice getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(ZalandoAPIPrice originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    
    
}
