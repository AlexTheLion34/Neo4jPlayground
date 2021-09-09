package com.playground.extension;

import com.playground.model.Neo4jItem;

import java.util.Optional;
import java.util.function.Function;

public class OptionalUnpackHelper<T extends Neo4jItem> {

    @SuppressWarnings(value = "OptionalUsedAsFieldOrParameterType")
    public Optional<T> unpack(Optional<T> optional, Function<T, Optional<T>> ifPresent) {
        if (optional.isPresent())
            return ifPresent.apply(optional.get());
        else return Optional.empty();
    }
}
