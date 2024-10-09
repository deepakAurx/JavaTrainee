package com.aurx.main.product;

import java.util.Arrays;
import java.util.List;

public class Product {
    private int id;
    private String title;
    private String description;
    private double price;
    private String brand;
    private String image;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) throws Exception {
        if(price<0){
            throw new Exception("price can not be negative");
        }
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setImages(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getImages() {
        return image;
    }

    public int getId() {
        return id;
    }

    public Product() {
    }

    public Product(int id, String title, String description, double price, String brand, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.brand = brand;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", images=" + image +
                '}';
    }
}


