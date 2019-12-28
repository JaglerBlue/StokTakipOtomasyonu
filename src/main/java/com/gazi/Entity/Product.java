/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gazi.Entity;

/**
 *
 * @author fakdi
 */
public class Product {

    private int id;
    private String productName;
    private int quantityOfStock;
    private int categoryId;

    public Product(String productName, int quantityOfStock, int categoryId) {
        this.productName = productName;
        this.quantityOfStock = quantityOfStock;
        this.categoryId = categoryId;
    }
    
     public Product(String productName, int quantityOfStock) {
        this.productName = productName;
        this.quantityOfStock = quantityOfStock;
    }
     
     public Product(String productName) {
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantityOfStock() {
        return quantityOfStock;
    }

    public void setQuantityOfStock(int quantityOfStock) {
        this.quantityOfStock = quantityOfStock;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
