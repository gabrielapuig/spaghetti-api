package com.example.spaghetti.controller;

import com.example.spaghetti.model.Item;
import com.example.spaghetti.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public List<Item> listAll() {
        return service.getAllItems();
    }

    @PostMapping("/list")
    public Item addItem(@RequestBody Item item) {
        return service.createItem(item);
    }

    @GetMapping("/listItem")
    public Item getItemById(@RequestParam("id") String id) {
        return service.getItemById(id);
    }

    @DeleteMapping("/list")
    public String removeItem(@RequestParam("id") String id) {
        return service.deleteItemById(id);
    }
}
