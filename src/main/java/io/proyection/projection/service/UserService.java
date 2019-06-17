package io.proyection.projection.service;

import io.proyection.projection.domain.User;
import io.proyection.projection.exception.UserIdException;
import io.proyection.projection.exception.UsernameAlreadyExistsException;
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

    public User saveUser (User newUser){

        try{
            newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
            //Username has to be unique (exception)
            newUser.setUsername(newUser.getUsername());
            // Make sure that password and confirmPassword match
            // We don't persist or show the confirmPassword
            newUser.setConfirmPassword("");
            return userRepository.save(newUser);

        }catch (Exception e){
            throw new UsernameAlreadyExistsException("Username '"+newUser.getUsername()+"' already exists");
        }
    }

    public User updateUser(User user){
        try{
            return userRepository.save(user);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public User findUserById(Long id){
        User user = userRepository.getById(id);

        if(user == null){
            throw new UserIdException("User ID '"+id+"' does not exist");
        }

        return user;
    }

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    public boolean deleteUser(Long id){

        try{
            userRepository.delete(findUserById(id));
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
