package io.proyection.projection.service;

import io.proyection.projection.domain.User;
import io.proyection.projection.exception.EmailAlreadyExistException;
import io.proyection.projection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User save(User user) {
        try {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

            //Email is unique (exception)
            user.setEmail(user.getEmail());

            //Make sure that passwords match

            //We don't persist confirmPassword
            user.setConfirmPassword("");

            return userRepository.save(user);
        } catch(Exception e) {
            throw new EmailAlreadyExistException("Email  '" + user.getEmail() + "' already exisits");
        }

    }
}
