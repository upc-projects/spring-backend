package io.proyection.projection.service;

import io.proyection.projection.domain.User;
import io.proyection.projection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.getById(id);
    }

    public void delete(Long id) {
        User user = findById(id);
        userRepository.delete(user);
    }
}
