package dev.jerry.restfulwebservices.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    private UserDaoService service;

    public UserResource(UserDaoService service){
        this.service = service;
    }

    //Get Users
    @GetMapping(path = "/users" )
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping(path = "/user/{id}" )
    public User retrieveUser(@PathVariable int id){
        return service.findOne(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> crateUser(@RequestBody User user){
        User savedUser  = service.save(user);
        // return the /users/{id}
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build(); //to provide the status of the request
    }
}
