package com.lcwd.user.service.services;

import com.lcwd.user.service.entities.User;

import java.util.List;

public interface UserService {

    // User Operation
    //create User
    User saveUser(User user);

    //get All User
    List<User> getAllUser();
    // get single user of given userId
     User getUser(String userId);
     // TODO: delete
    void deleteUser(String userId);
    // TODO: update
    User updateUser(User user, String userId);

}
