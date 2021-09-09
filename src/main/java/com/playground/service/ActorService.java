package com.playground.service;

import com.playground.extension.OptionalUnpackHelper;
import com.playground.model.Actor;
import com.playground.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActorService extends Neo4jItemService<Actor> {

    @Autowired
    public ActorService(ActorRepository repository, OptionalUnpackHelper<Actor> personUnpacker) {
        super(repository, personUnpacker);
    }

    public Optional<Actor> getItem(Actor actor) {
        return ((ActorRepository) repository)
                .findByName(actor.getName());
    }

    public Optional<Actor> updateItem(Long id, Actor actor) {
        return itemUnpacker
                .unpack(
                        repository.findById(id),
                        p -> {
                            p.setName(actor.getName());
                            p.setBorn(actor.getBorn());
                            repository.save(p);
                            return Optional.of(p);
                        });
    }

    public Optional<Actor> deleteItem(Long id) {
        return itemUnpacker
                .unpack(
                        repository.findById(id),
                        p -> {
                            repository.delete(p);
                            return Optional.of(p);
                        });
    }
}
