package com.example.restaurent.entity;

import jakarta.persistence.*;

@Entity
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    // Constructors
    public MenuItem() {}

    public MenuItem(Long id, String name, String description, double price, Restaurant restaurant) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.restaurant = restaurant;
    }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public Restaurant getRestaurant() { return restaurant; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setPrice(double price) { this.price = price; }
    public void setRestaurant(Restaurant restaurant) { this.restaurant = restaurant; }
}
