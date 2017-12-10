package ca.irvine.cinema_inner_world.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import ca.irvine.cinema_inner_world.repository.UserRepository;
import ca.irvine.cinema_inner_world.model.User;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> login(String identifier, String password){
        Optional<User> optionalUser = userRepository.findByUsername(identifier);
        if (!optionalUser.isPresent()){
            optionalUser = userRepository.findByEmail(identifier);
        }
        return optionalUser.filter(user -> user.getPassword().equals(password));
    }

    public Optional<User> register(String username, String password, String email, String phoneNumber){
        Optional<User> optionalUser = userRepository.findByUsername(username);

        if(!optionalUser.isPresent()){
            User user = new User();

            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setPhoneNumber(phoneNumber);
            
            userRepository.save(user);

            return Optional.of(user);
        }
        return Optional.empty();
    }
}