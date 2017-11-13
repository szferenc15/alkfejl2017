package ca.irvine.cinema_world.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.irvine.cinema_world.service.UserService;
import ca.irvine.cinema_world.model.User;
import java.util.Optional;

import ca.irvine.cinema_world.util.Response;

@RestController
@RequestMapping("/")
public class UserController{

    @Autowired
    private UserService userService;

    @RequestMapping(value= "login", method=RequestMethod.POST )
    public Response<User> login(
                                @RequestParam(value="identifier") String identifier, 
                                @RequestParam(value="password") String password
                                )
    {
        Optional<User> optionalUser = userService.login(identifier, password);

        if(optionalUser.isPresent()){
            User user = optionalUser.get();

            return Response.ok(user); 
        }

        return Response.error("Wrong username or password!");
    }

    @RequestMapping(value= "register", method=RequestMethod.POST )
    public Response<User> register(
                                    @RequestParam(value="username") String username, 
                                    @RequestParam(value="password") String password,
                                    @RequestParam(value="email") String email,
                                    @RequestParam(value="phoneNumber") String phoneNumber
                                    )
    {
        Optional<User> optionalUser = userService.register(username, password, email, phoneNumber);

        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            return Response.ok(user); 
        }

        return Response.error("Username is already in use!");
    }
}