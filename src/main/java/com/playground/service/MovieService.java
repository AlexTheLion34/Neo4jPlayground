package com.playground.service;

import com.playground.extension.OptionalUnpackHelper;
import com.playground.model.Movie;
import com.playground.model.Actor;
import com.playground.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieService extends Neo4jItemService<Movie> {

    @Autowired
    public MovieService(MovieRepository movieRepository,
                        ActorService actorService,
                        OptionalUnpackHelper<Movie> movieUnpacker) {
        super(movieRepository, movieUnpacker);
        this.actorService = actorService;
    }

    private final ActorService actorService;

    public Optional<Movie> updateItem(Long id, Movie movie) {
        return itemUnpacker
                .unpack(
                        repository.findById(id),
                        mov -> {
                            mov.setReleased(movie.getReleased());

                            Set<Actor> peopleFromDb = peopleFromDb(movie.getActors());
                            Set<Actor> peopleNotFromDb = peopleNotFromDb(movie.getActors());

                            System.out.println(peopleFromDb);

                            mov.getActors().addAll(peopleFromDb);
                            mov.getActors().addAll(peopleNotFromDb);

                            repository.save(mov);
                            return Optional.of(mov);
                        });
    }

    public Optional<Movie> deleteItem(Long id) {
        return itemUnpacker
                .unpack(
                        repository.findById(id),
                        mov -> {
                            repository.delete(mov);
                            return Optional.of(mov);
                        });
    }

    private Set<Actor> peopleFromDb(Set<Actor> actorCandidates) {
        return actorCandidates
                .stream()
                .map(actorService::getItem)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }

    private Set<Actor> peopleNotFromDb(Set<Actor> actorCandidates) {
        return actorCandidates
                .stream()
                .filter(p -> actorService.getItem(p).isEmpty())
                .collect(Collectors.toSet());
    }
}
