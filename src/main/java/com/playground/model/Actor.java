package com.playground.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Actor extends Neo4jItem {

    public Actor(String name, Integer born) {
        this.name = name;
        this.born = born;
    }

    private Integer born;

    private String name;
}
