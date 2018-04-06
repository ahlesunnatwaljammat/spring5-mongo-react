package edu.learn.mongo.repos;

import edu.learn.mongo.entities.Roles;
import edu.learn.mongo.entities.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepo extends ReactiveMongoRepository<User, String> {
    Mono<User> findByUsername(String username);
    Flux<User> findByRole_Role(Roles role);
}
