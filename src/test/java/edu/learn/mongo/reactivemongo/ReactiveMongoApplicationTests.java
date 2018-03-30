package edu.learn.mongo.reactivemongo;

import edu.learn.mongo.repos.UserRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT)
@EnableReactiveMongoRepositories(basePackages = {"edu.learn.mongo.repos"})
public class ReactiveMongoApplicationTests {

	@Autowired
	private UserRepo userRepo;

	@Test
	public void contextLoads() {
	}

}
