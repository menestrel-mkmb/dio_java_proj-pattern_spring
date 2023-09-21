package edu.project.spring.patterns.service;

import edu.project.spring.patterns.model.Address;
import edu.project.spring.patterns.model.AddressRepository;
import edu.project.spring.patterns.model.User;
import edu.project.spring.patterns.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private AddressRepository addressRepo;
    @Autowired
    private AddressService viaCepService;
    @Override
    public Iterable<User> findAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User findUserById(Long id) {
        User user = userRepo.findById(id).get();
        return user;
    }

    @Override
    public void createUser(User user) {
        saveAddress(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        Optional<User> updated = userRepo.findById(id);
        if(updated.isPresent()) {
            saveAddress(user);
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    private User saveAddress(User user) {
        String cep = user.getAddress().getCep();
        Address add = addressRepo.findById(cep).orElseGet(() -> {
            Address intAdd = viaCepService.getAddress(cep);
            addressRepo.save(intAdd);
            return intAdd;
        });
        user.setAddress(add);
        userRepo.save(user);
        return user;
    }
}
