package com.playground.controller;

import com.playground.model.Actor;
import com.playground.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/actors")
public class ActorController extends Neo4jItemController<Actor> {

    @Autowired
    public ActorController(ActorService service) {
        super(service);
    }
}
