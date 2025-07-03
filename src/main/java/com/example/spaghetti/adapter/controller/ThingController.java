package com.example.spaghetti.adapter.controller;

import com.example.spaghetti.adapter.dto.mapper.ThingMapper;
import com.example.spaghetti.adapter.dto.request.ThingRequest;
import com.example.spaghetti.adapter.dto.response.ThingResponse;
import com.example.spaghetti.domain.model.Thing;
import com.example.spaghetti.infrastructure.util.Utils;
import com.example.spaghetti.application.service.ThingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/things")
public class ThingController {

    private final ThingService service;
    private final Utils utils;
    private final ThingMapper mapper;

    public ThingController(ThingService service, ThingMapper mapper) {
        this.service = service;
        this.utils = new Utils();
        this.mapper = mapper;
    }

    @GetMapping("/list")
    public List<ThingResponse> getList() {
        List<Thing> thingList = service.getAllThings();
        return mapper.toResponseList(thingList);
    }

    @PostMapping("/list")
    public ThingResponse addItem(@RequestBody ThingRequest thingRequest) {
        int letterCount = utils.countLetters(thingRequest.getName());
        System.out.println("Name has " + letterCount + " letters.");
        Thing thingEntity = mapper.toEntity(thingRequest);
        Thing saved = service.addThing(thingEntity);
        return mapper.toResponse(saved);
    }

    @DeleteMapping("/list")
    public void removeItem(@RequestParam("id") String id) {
        service.removeThing(id);
    }
}
