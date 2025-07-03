package com.example.spaghetti.domain.repository;

import com.example.spaghetti.domain.model.Item;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ItemRepository {
    private final List<Item> items = new ArrayList<>();

    public List<Item> findAll() {
        return new ArrayList<>(items);
    }

    public Item add(Item item) {
        items.add(item);
        return item;
    }

    public Optional<Item> findById(String id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }

    public boolean deleteById(String id) {
        return items.removeIf(thing -> thing.getId().equals(id));
    }
}
