package edu.learn.mongo.repos;

import edu.learn.mongo.entities.Role;
import edu.learn.mongo.entities.Roles;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RoleRepo extends ReactiveMongoRepository<Role, Roles> {
}
