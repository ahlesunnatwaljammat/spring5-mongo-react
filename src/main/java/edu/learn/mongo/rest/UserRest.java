package edu.learn.mongo.rest;

import edu.learn.mongo.entities.User;
import edu.learn.mongo.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@CrossOrigin(origins = {"http://localhost:3000","http://noman:3000"})
@RestController
@RequestMapping(path = "/api/users")
public class UserRest {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @GetMapping
    public Flux<User> allUser(){
        System.out.println(this.gridFsTemplate);
        return this.userRepo.findAll();
    }
}
