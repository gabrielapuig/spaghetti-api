package com.example.spaghetti.controller;

import com.example.spaghetti.model.Item;
import com.example.spaghetti.service.ItemService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Predicate;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService service;
    private final Predicate<String> nameValidator;

    public ItemController(ItemService service,
                          @Qualifier("nameStartsWithUppercaseValidator") Predicate<String> nameValidator) {
        this.service = service;
        this.nameValidator = nameValidator;
    }
    @GetMapping("/list")
    public List<Item> listAll() {
        return service.getAllItems();
    }

    @PostMapping("/list")
    public ResponseEntity<?> addItem(@RequestBody Item item) {
        if (!nameValidator.test(item.getName())) {
            return ResponseEntity.badRequest().body("Name must start with an uppercase letter.");
        }
        return ResponseEntity.ok(service.createItem(item));
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
