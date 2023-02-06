package com.example.pathfinder2021ch.service;

import com.example.pathfinder2021ch.domain.serviceDto.UserServiceModel;

public interface UserService {


    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);
}
