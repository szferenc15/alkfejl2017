package ca.irvine.cinema_inner_world.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.irvine.cinema_inner_world.service.UserService;
import ca.irvine.cinema_inner_world.model.User;
import java.util.Optional;
import ca.irvine.cinema_inner_world.util.Response;

class AuthUser {
    private String identifier;
    private String password;

    /**
     * @return the identifier
     */
    public String getIdentifier() {
        return identifier;
    }
    
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
}

@RestController
@RequestMapping("/user")
public class UserController{

    @Autowired
    private UserService userService;

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(value= "/login", method=RequestMethod.POST, consumes="application/json")
    public Response<User> login(@RequestBody AuthUser user)
    {
        System.out.print(user.toString());
        Optional<User> optionalUser = userService.login(user.getIdentifier(), user.getPassword());

        if(optionalUser.isPresent()){
            User loggedUser = optionalUser.get();

            return Response.ok(loggedUser); 
        }

        return Response.error("Wrong username or password!");
    }

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(value= "/register", method=RequestMethod.POST )
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