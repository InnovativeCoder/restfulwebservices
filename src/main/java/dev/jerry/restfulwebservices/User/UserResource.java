package dev.jerry.restfulwebservices.User;

import org.springframework.web.bind.annotation.*;

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
    public void crateUser(@RequestBody User user){
        service.save(user);
    }
}
