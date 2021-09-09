package com.playground.controller;

import com.playground.exeption.ItemDoesNotExistException;
import com.playground.model.Neo4jItem;
import com.playground.service.Neo4jItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class Neo4jItemController<T extends Neo4jItem> {

    public Neo4jItemController(Neo4jItemService<T> service) {
        this.service = service;
    }

    private final Neo4jItemService<T> service;

    @GetMapping
    @ResponseBody
    public List<T> getAllItems() {
        return service.getAllItems();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public T getItem(@PathVariable Long id) {
        return service
                .getItem(id)
                .orElseThrow(() -> new ItemDoesNotExistException("Provided item does not exist"));
    }

    @PostMapping
    @ResponseBody
    public T createItem(@RequestBody T item) {
        return service.createItem(item);
    }

    @PutMapping(value = "/{id}")
    @ResponseBody
    public T updateItem(@PathVariable Long id, @RequestBody T item) {
        return service
                .updateItem(id, item)
                .orElseThrow(() -> new ItemDoesNotExistException("Provided item does not exist"));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public T deleteItem(@PathVariable Long id) {
        return service
                .deleteItem(id)
                .orElseThrow(() -> new ItemDoesNotExistException("Provided item does not exist"));
    }
}
