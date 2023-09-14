package dev.jerry.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping( path="/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping( path="/hello-world-bean")
    public HelloWorldBean HelloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    //Variable Path Name
    @GetMapping(path="/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name){
        return new HelloWorldBean("Hello World "+name);
    }
}
