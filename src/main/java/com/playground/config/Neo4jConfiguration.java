package com.playground.config;

import com.playground.model.Movie;
import com.playground.model.Actor;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.AbstractNeo4jConfig;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.util.Collection;
import java.util.List;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.playground.repository")
public class Neo4jConfiguration extends AbstractNeo4jConfig {

    @Value(value = "${spring.neo4j.url}")
    private String url;

    @Value(value = "${spring.neo4j.db}")
    private String dataBase;

    @Value(value = "${spring.neo4j.password}")
    private String password;

    @Bean
    public Driver driver() {
        return GraphDatabase.driver(url, AuthTokens.basic(dataBase, password));
    }

    @Override
    protected Collection<String> getMappingBasePackages() {
        return List.of(
                Actor.class.getPackage().getName(),
                Movie.class.getPackage().getName()
        );
    }
}
