package edu.learn.mongo.repos;

import edu.learn.mongo.entities.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepo extends ReactiveMongoRepository<User, Long> {
}
