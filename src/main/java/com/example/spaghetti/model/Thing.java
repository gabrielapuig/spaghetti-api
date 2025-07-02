package com.example.spaghetti.model;

import java.util.UUID;

public class Thing {
    private String id;
    private String name;

    public Thing() {
        this.id = UUID.randomUUID().toString();
    }

    public Thing(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
