package edu.project.spring.patterns.service;

import edu.project.spring.patterns.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface {
    @Override
    public Iterable<User> findAllUsers() {
        return null;
    }

    @Override
    public User findUserById(Long id) {
        return null;
    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public void updateUser(Long id, User user) {

    }

    @Override
    public void deleteUser(Long id) {

    }
}
