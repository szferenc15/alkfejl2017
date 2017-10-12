package edu.elte.hello.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.elte.hello.service.UserService;
import edu.elte.hello.model.User;

import java.util.Optional;

import edu.elte.hello.util.Response;

@RestController
@RequestMapping("/api")
public class UserController{

    @Autowired
    private UserService userService;
/*
    @RequestMapping("/user")
    public User user(@RequestParam(value="username") String username){
        return userRepository.findByUsername(username).get();
    }
*/  
    @RequestMapping("/login")
    public Response<User> login(@RequestParam(value="username") String username, @RequestParam(value="password") String password){
        Optional<User> optionalUser = userService.login(username, password);

        if(optionalUser.isPresent()){
            User user = optionalUser.get();

            //create new token
            
            return Response.ok(user); 
        }

        return Response.error("Wrong username-password pair");
    }

    @RequestMapping(value= "/register", method=RequestMethod.POST )
    public Response<User> register(@RequestParam(value="username") String username, @RequestParam(value="password") String password){
        Optional<User> optionalUser = userService.register(username, password);

        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            return Response.ok(user); 
        }

        return Response.error("Username is already in use!");
    }
}