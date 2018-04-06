package edu.learn.mongo.reactivemongo;

import edu.learn.mongo.entities.Role;
import edu.learn.mongo.entities.Roles;
import edu.learn.mongo.entities.User;
import edu.learn.mongo.repos.RoleRepo;
import edu.learn.mongo.repos.UserRepo;
import edu.learn.mongo.rest.UserRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import reactor.core.publisher.Mono;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.learn.mongo.rest"})
@EnableReactiveMongoRepositories(basePackages = {"edu.learn.mongo.repos"})
public class ReactiveMongoApplication {

    private Logger logger = LoggerFactory.getLogger(ReactiveMongoApplication.class);

    @Bean
    public CommandLineRunner addSampleRole(RoleRepo roleRepo){
        return args -> {
            logger.info("======================================");
            Role role = new Role();
            role.setRole(Roles.ADMIN);
            roleRepo.save(role).block();

        };
    }

    @Bean
    public CommandLineRunner addSampleUser(UserRepo userRepo, RoleRepo roleRepo){
        return args -> {
            Role role = roleRepo.findById(Roles.ADMIN).block();
            User userWithRole = new User("ur","x");
            userWithRole.setRole(role);
            userRepo.save(userWithRole).block();

            logger.info("======================================");
            userRepo.save(new User("nabbasi","x", Roles.ADMIN)).subscribe();
            userRepo.save(new User("fabbasi","x", Roles.ADMIN)).subscribe();
            userRepo.save(new User("aabbasi","x", Roles.USERS)).subscribe();
            userRepo.save(new User("dabbasi","x", Roles.USERS)).subscribe();
            userRepo.save(new User("uabbasi","x", Roles.USERS)).subscribe();

            logger.info("======================================");
            logger.info("Find all users");
            userRepo.findAll().toStream().forEach(user -> {
                logger.info(user.toString());
            });

            logger.info("======================================");
            logger.info("Find user by ur");
            User user = userRepo.findByUsername("ur").block();
            logger.info(user.toString());

            logger.info("======================================");
            logger.info("Find user by role");
            userRepo.findByRole_Role(Roles.ADMIN).subscribe(users -> {
                logger.info(users.toString());
            });

        };
    }

	public static void main(String[] args) {
		SpringApplication.run(ReactiveMongoApplication.class, args);
	}
}
