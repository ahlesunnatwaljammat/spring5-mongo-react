package edu.learn.mongo.reactivemongo;

import edu.learn.mongo.repos.UserRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT)
@ComponentScan(basePackages = {"edu.learn"})
@EnableReactiveMongoRepositories(basePackages = {"edu.learn.mongo.repos"})
@EnableJpaRepositories(basePackages = {"edu.learn.jpa.repos"})
public class ReactiveMongoApplicationTests {

	@Autowired
	private UserRepo userRepo;

	@Test
	public void contextLoads() {
	}

}
