package com.example.spaghetti.service;

import com.example.spaghetti.model.Item;
import com.example.spaghetti.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public Item createItem(Item item) {
        return repository.add(item);
    }

    public List<Item> getAllItems() {
        return repository.findAll();
    }

    public Item getItemById(String id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteItemById(String id) {
        boolean deleted = repository.deleteById(id);
        return deleted ? "Item " + id + " removed" : "Invalid index";
    }
}
