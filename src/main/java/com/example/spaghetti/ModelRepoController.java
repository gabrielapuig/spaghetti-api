package com.example.spaghetti;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/items")
public class ModelRepoController {

    private Map<Long, Item> storage = new HashMap<>();
    private AtomicLong idGen = new AtomicLong();

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        long id = idGen.incrementAndGet();
        item.setId(id);
        storage.put(id, item);
        return item;
    }

    @GetMapping
    public Collection<Item> listAll() {
        return storage.values();
    }

    @GetMapping("/{id}")
    public Item getById(@PathVariable Long id) {
        return storage.get(id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        if (storage.remove(id) != null) {
            return "Item " + id + " removed";
        }
        return "Item not found";
    }

    public static class Item {
        private Long id;
        private String name;
        private String description;

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
    }
}