package com.example.spaghetti.repository;

import com.example.spaghetti.model.Thing;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ThingRepository {
    private final List<Thing> things = new ArrayList<>();

    public List<Thing> findAll() {
        return new ArrayList<>(things);
    }

    public Thing add(Thing thing) {
        things.add(thing);
        return thing;
    }

    public boolean remove(String id) {
        return things.removeIf(thing -> thing.getId().equals(id));
    }
}
