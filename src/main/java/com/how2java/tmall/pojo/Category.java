package com.how2java.tmall.pojo;

import java.util.List;

public class Category {
    private Integer id;

    private String name;

    /* 非数据库字段*/
    private List<Product> products;

    private List<List<Product>> productsByRow;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<List<Product>> getProductByRow() {
        return productsByRow;
    }

    public void setProductByRow(List<List<Product>> productByRow) {
        this.productsByRow = productsByRow;
    }
}