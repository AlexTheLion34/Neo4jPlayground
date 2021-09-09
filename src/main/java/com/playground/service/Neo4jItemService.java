package com.playground.service;

import com.playground.extension.OptionalUnpackHelper;
import com.playground.model.Neo4jItem;
import com.playground.repository.Neo4jItemRepository;

import java.util.List;
import java.util.Optional;

public abstract class Neo4jItemService<T extends Neo4jItem> {

    public Neo4jItemService(Neo4jItemRepository<T> repository, OptionalUnpackHelper<T> itemUnpacker) {
        this.repository = repository;
        this.itemUnpacker = itemUnpacker;
    }

    protected final OptionalUnpackHelper<T> itemUnpacker;

    protected final Neo4jItemRepository<T> repository;

    public List<T> getAllItems() {
        return repository.findAll();
    }

    public Optional<T> getItem(Long id) {
        return repository.findById(id);
    }

    public T createItem(T item) {
        return repository.save(item);
    }

    public abstract Optional<T> updateItem(Long id, T item);

    public abstract Optional<T> deleteItem(Long id);
}
