package com.example.restaurent.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private String contactNumber;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MenuItem> menuItems;

    // Constructors
    public Restaurant() {}

    public Restaurant(Long id, String name, String location, String contactNumber) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.contactNumber = contactNumber;
    }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public String getContactNumber() { return contactNumber; }
    public List<MenuItem> getMenuItems() { return menuItems; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setLocation(String location) { this.location = location; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public void setMenuItems(List<MenuItem> menuItems) { this.menuItems = menuItems; }
}
