package com.example.spaghetti.controller;

import com.example.spaghetti.util.Utils;
import com.example.spaghetti.model.Thing;
import com.example.spaghetti.service.ThingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/things")
public class ThingController {

    private final ThingService service;
    private final Utils utils;

    public ThingController(ThingService service) {
        this.service = service;
        this.utils = new Utils();
    }

    @GetMapping("/list")
    public List<Thing> getList() {
        return service.getAllThings();
    }

    @PostMapping("/list")
    public Thing addItem(@RequestBody Thing thing) {
        int letterCount = utils.countLetters(thing.getName());
        System.out.println("Name has " + letterCount + " letters.");
        return service.addThing(thing);
    }

    @DeleteMapping("/list")
    public String removeItem(@RequestParam("id") String id) {
        return service.removeThing(id);
    }
}
