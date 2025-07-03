package com.example.spaghetti.application.service;

import com.example.spaghetti.domain.model.Thing;
import com.example.spaghetti.domain.repository.ThingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThingService {

    private final ThingRepository repository;

    public ThingService(ThingRepository repository) {
        this.repository = repository;
    }

    public List<Thing> getAllThings() {
        return repository.findAll();
    }

    public Thing addThing(Thing thing) {
        return repository.add(thing);
    }

    public String removeThing(String index) {
        boolean removed = repository.remove(index);
        return removed ? "Removed: " + index : "Invalid index";
    }
}
