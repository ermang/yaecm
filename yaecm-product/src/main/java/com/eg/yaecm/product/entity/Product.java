package com.eg.yaecm.product.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class Product extends BaseEntity {

    private String name;

    private String descr;

    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
