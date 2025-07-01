package com.example.spaghetti;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/things")
public class ControllerService {

    private List<String> list = new ArrayList<>();

    @GetMapping("/list")
    public List<String> getList() {
        return list;
    }

    @PostMapping("/list")
    public String addItem(@RequestBody String item) {
        list.add(item);
        return "Item added: " + item;
    }

    @DeleteMapping("/list/{index}")
    public String removeItem(@PathVariable int index) {
        if (index >= 0 && index < list.size()) {
            String removed = list.remove(index);
            return "Removed: " + removed;
        }
        return "Invalid index";
    }
}
