package ca.irvine.cinema_inner_world.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
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

class RegUser {
    private String username;
    private String password;
    private String email;
    private String phoneNumber;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
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
        Optional<User> optionalUser = userService.login(user.getIdentifier(), user.getPassword());

        if(optionalUser.isPresent()){
            User loggedUser = optionalUser.get();

            return Response.ok(loggedUser); 
        }

        return Response.error("Helyeten felhasznalonev vagy jelszo!");
    }

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(value= "/register", method=RequestMethod.POST, consumes="application/json")
    public Response<User> register(@RequestBody RegUser new_user)
    {
        System.out.print(new_user);
        Optional<User> optionalUser = userService.register(new_user.getUsername(), new_user.getPassword(), 
                                                           new_user.getEmail(), new_user.getPhoneNumber());
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            return Response.ok(user); 
        }

        return Response.error("Username is already in use!");
    }
}