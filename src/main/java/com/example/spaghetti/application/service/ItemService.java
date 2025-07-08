package com.example.spaghetti.application.service;

import com.example.spaghetti.domain.exception.InvalidItemNameException;
import com.example.spaghetti.domain.exception.ItemNotFoundException;
import com.example.spaghetti.domain.model.Item;
import com.example.spaghetti.domain.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class ItemService {

    private final ItemRepository repository;
    private final Predicate<String> nameValidator;

    public ItemService(ItemRepository repository, @Qualifier("nameStartsWithUppercaseValidator") Predicate<String> nameValidator) {
        this.repository = repository;
        this.nameValidator = nameValidator;
    }

    public Item createItem(Item item) {
        if (!nameValidator.test(item.getName())) {
            throw new InvalidItemNameException(item.getName());
        }
        return repository.add(item);
    }

    public List<Item> getAllItems() {
        return repository.findAll();
    }

    public Item getItemById(String id) {
        return repository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    public void deleteItemById(String id) {
        boolean removed = repository.deleteById(id);
        if (!removed) {
            throw new ItemNotFoundException(id);
        }
    }
}
