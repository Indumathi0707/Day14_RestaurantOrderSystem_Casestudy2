package com.example.restaurent.service;

import com.example.restaurent.entity.MenuItem;
import com.example.restaurent.entity.Restaurant;
import com.example.restaurent.exception.ResourceNotFoundException;
import com.example.restaurent.repository.MenuItemRepository;
import com.example.restaurent.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {

    private final MenuItemRepository menuItemRepo;
    private final RestaurantRepository restaurantRepo;

    public MenuItemService(MenuItemRepository menuItemRepo, RestaurantRepository restaurantRepo) {
        this.menuItemRepo = menuItemRepo;
        this.restaurantRepo = restaurantRepo;
    }

    public MenuItem addMenuItem(Long restaurantId, MenuItem menuItem) {
        Restaurant restaurant = restaurantRepo.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with ID: " + restaurantId));
        menuItem.setRestaurant(restaurant);
        return menuItemRepo.save(menuItem);
    }

    public List<MenuItem> getMenuItemsByRestaurant(Long restaurantId) {
        return menuItemRepo.findByRestaurantId(restaurantId);
    }

    public MenuItem updateMenuItem(Long id, MenuItem updated) {
        MenuItem menuItem = menuItemRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu item not found with ID: " + id));
        menuItem.setName(updated.getName());
        menuItem.setDescription(updated.getDescription());
        menuItem.setPrice(updated.getPrice());
        return menuItemRepo.save(menuItem);
    }

    public void deleteMenuItem(Long id) {
        menuItemRepo.deleteById(id);
    }
}
