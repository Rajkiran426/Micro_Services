package com.lcwd.user.service.services.impl;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.repositories.UserRepository;
import com.lcwd.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        //generate unique userid
        String randonUserId = UUID.randomUUID().toString();
        user.setUserId(randonUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {

        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("User with given id not found on server !!" +userId));
    }

    @Override
    public void deleteUser(String userId) {
         userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("User with given id not found on server !!"+userId));
    }

    @Override
    public User updateUser(User user, String userId) {
        User user1 = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User with given id not found on server !!" + userId)
        );
       return userRepository.save(user1);
    }
}
