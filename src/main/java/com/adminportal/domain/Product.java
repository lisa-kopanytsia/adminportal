package com.adminportal.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    private String category;
    @Column(name = "weight")
    private double weight;
    @Column(name = "list_price")
    private int listPrice;
    @Column(name = "price")
    private int price;
    @Column(name = "active")
    private boolean active=true;
    @Column(columnDefinition = "text")
    private String description;
    @Transient
    private MultipartFile img;
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<ProductToCartItem> productToCartItemList;

    public Product() {
    }

    public Product(long id, String name, String category, double weight, int listPrice, int price, boolean active, String description, MultipartFile img) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.weight = weight;
        this.listPrice = listPrice;
        this.price = price;
        this.active = active;
        this.description = description;
        this.img = img;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getListPrice() {
        return listPrice;
    }

    public void setListPrice(int listPrice) {
        this.listPrice = listPrice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }

    public List<ProductToCartItem> getProductToCartItemList() {
        return productToCartItemList;
    }

    public void setProductToCartItemList(List<ProductToCartItem> productToCartItemList) {
        this.productToCartItemList = productToCartItemList;
    }
}
