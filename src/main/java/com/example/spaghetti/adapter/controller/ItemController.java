package com.example.spaghetti.adapter.controller;

import com.example.spaghetti.adapter.dto.mapper.ItemMapper;
import com.example.spaghetti.adapter.dto.request.ItemRequest;
import com.example.spaghetti.adapter.dto.response.ItemResponse;
import com.example.spaghetti.domain.model.Item;
import com.example.spaghetti.application.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService service;
    private final ItemMapper mapper;

    public ItemController(ItemService service, ItemMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }
    @GetMapping("/list")
    public List<ItemResponse> listAll() {
        List<Item> itemList = service.getAllItems();
        return mapper.toResponseList(itemList);
    }

    @PostMapping("/list")
    public ResponseEntity<ItemResponse> addItem(@RequestBody ItemRequest itemRequest) {
        Item itemEntity = mapper.toEntity(itemRequest);
        Item saved = service.createItem(itemEntity);
        return ResponseEntity.ok(mapper.toResponse(saved));
    }

    @GetMapping("/listItem")
    public ItemResponse getItemById(@RequestParam("id") String id) {
        Item itemById = service.getItemById(id);
        return mapper.toResponse(itemById);
    }

    @DeleteMapping("/list")
    public void removeItem(@RequestParam("id") String id) {
        service.deleteItemById(id);
    }
}
