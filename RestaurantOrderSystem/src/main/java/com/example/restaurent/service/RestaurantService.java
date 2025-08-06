package com.example.restaurent.service;

import com.example.restaurent.entity.Restaurant;
import com.example.restaurent.exception.ResourceNotFoundException;
import com.example.restaurent.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepo;

    public RestaurantService(RestaurantRepository restaurantRepo) {
        this.restaurantRepo = restaurantRepo;
    }

    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepo.save(restaurant);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepo.findAll();
    }

    public Restaurant getRestaurantById(Long id) {
        return restaurantRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with ID: " + id));
    }

    public Restaurant updateRestaurant(Long id, Restaurant updated) {
        Restaurant restaurant = getRestaurantById(id);
        restaurant.setName(updated.getName());
        restaurant.setLocation(updated.getLocation());
        restaurant.setContactNumber(updated.getContactNumber());
        return restaurantRepo.save(restaurant);
    }

    public void deleteRestaurant(Long id) {
        restaurantRepo.deleteById(id);
    }
}
