package com.example.pathfinder2021ch.service;

import com.example.pathfinder2021ch.domain.entity.UserEntity;
import com.example.pathfinder2021ch.domain.entity.enums.LevelUserEnum;
import com.example.pathfinder2021ch.domain.serviceDto.UserServiceModel;
import com.example.pathfinder2021ch.repository.UserRepository;
import com.example.pathfinder2021ch.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    private  final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper,
                           CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }


    @Override
    public void registerUser(UserServiceModel userServiceModel) {


        UserEntity user = modelMapper.map(userServiceModel, UserEntity.class);
        user.setLevel(LevelUserEnum.BEGINNER);

        userRepository.save(user);

    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findUserEntityByUsernameAndPassword(username, password)
                .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {

            currentUser.setId(id).setUsername(username);

    }

    @Override
    public void logOut() {

        currentUser.setId(null).setUsername(null);
    }

    @Override
    public UserServiceModel findById(Long id) {

        return userRepository.findById(id)
                .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
                .orElse(null);

    }


}
