package edu.learn.jpa.reactivejpa;

import edu.learn.jpa.entities.User;

import edu.learn.jpa.repos.UserJpaRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"edu.learn.jpa.entities"})
@ComponentScan(basePackages = {"edu.learn"})
@EnableJpaRepositories(basePackages = {"edu.learn.jpa.repos"})
public class ReactiveJpaApplication {
    private final Logger logger = LoggerFactory.getLogger(ReactiveJpaApplication.class);
    @Bean
    public CommandLineRunner addJpaUser(UserJpaRepo userRepo){
        return args -> {
            logger.info("============================= Adding sample users =============================");
            userRepo.save(new User("nabbasi","x"));
            userRepo.save(new User("fabbasi","x"));

            userRepo.findAll().forEach(user ->
                logger.info(user.toString())
            );
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ReactiveJpaApplication.class, args);
    }
}
