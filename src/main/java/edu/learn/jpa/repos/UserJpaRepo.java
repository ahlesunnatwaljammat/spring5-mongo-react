package edu.learn.jpa.repos;

import edu.learn.jpa.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserJpaRepo extends CrudRepository<User, Long> {
}
