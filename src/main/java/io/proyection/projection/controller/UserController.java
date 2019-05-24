package io.proyection.projection.controller;

import io.proyection.projection.domain.User;
import io.proyection.projection.exception.ResourceNotFoundException;
import io.proyection.projection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public Boolean getAllUsers(Sort user) {
    	boolean flag = false;
        try {
        	userRepository.findAll(user);
        	flag = true;
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
    	return flag;
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userRepository.getById(userId);
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable Long userId, @Valid @RequestBody User userRequest) {
        return userRepository.findById(userId).map(user -> {
            user.setEmail(userRequest.getEmail());
            user.setFirstname(userRequest.getFirstname());
            user.setLastname(userRequest.getLastname());
            user.setUsername(userRequest.getUsername());
            user.setPassword(userRequest.getPassword());
            user.setEnabled(userRequest.isEnabled());
            return userRepository.save(user);
        }).orElseThrow(() -> new ResourceNotFoundException("UserId " + userId + " not found"));
    }

    @DeleteMapping("/users/{userId}")
    public User deleteUser(@PathVariable Long userId) {
        return userRepository.findById(userId).map(user -> {
            userRepository.delete(user);
            return user;
        }).orElseThrow(() -> new ResourceNotFoundException("UserId " + userId + " not found"));
    }
}
