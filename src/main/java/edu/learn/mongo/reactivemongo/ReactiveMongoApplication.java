package edu.learn.mongo.reactivemongo;

import edu.learn.mongo.entities.User;
import edu.learn.mongo.repos.UserRepo;
import edu.learn.mongo.rest.UserRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.learn.mongo.rest"})
@EnableReactiveMongoRepositories(basePackages = {"edu.learn.mongo.repos"})
public class ReactiveMongoApplication {

    private Logger logger = LoggerFactory.getLogger(ReactiveMongoApplication.class);

    @Bean
    public CommandLineRunner addSampleData(UserRepo userRepo){
        return args -> {
            logger.info("======================================");
            userRepo.save(new User("nabbasi","x")).subscribe();
            userRepo.save(new User("fabbasi","x")).subscribe();
            userRepo.save(new User("aabbasi","x")).subscribe();
            userRepo.save(new User("dabbasi","x")).subscribe();
            userRepo.save(new User("uabbasi","x")).subscribe();

            logger.info("======================================");
            logger.info("Find all users");
            userRepo.findAll().toStream().forEach(user -> {
                logger.info(user.toString());
            });
        };
    }

    @Bean
    public CommandLineRunner restSample(UserRest userRest){
        return args -> {

        };
    }

	public static void main(String[] args) {
		SpringApplication.run(ReactiveMongoApplication.class, args);
	}
}
