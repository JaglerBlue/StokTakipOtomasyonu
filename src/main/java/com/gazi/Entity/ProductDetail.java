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
public class ProductDetail {
    private String productName;
    private int quantityOfStock;
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ProductDetail(String productName, int quantityOfStock, String categoryName) {
        this.productName = productName;
        this.quantityOfStock = quantityOfStock;
        this.categoryName = categoryName;
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

    public String getCategoryId() {
        return categoryName;
    }

    public void setCategoryId(String categoryName) {
        this.categoryName = categoryName;
    }
}
