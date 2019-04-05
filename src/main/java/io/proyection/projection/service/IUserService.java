package io.proyection.projection.service;

import io.proyection.projection.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    public User save(User user);

    public Iterable<User> findAll();

    public User findById(Long id);

    public void delete(Long id);
}
