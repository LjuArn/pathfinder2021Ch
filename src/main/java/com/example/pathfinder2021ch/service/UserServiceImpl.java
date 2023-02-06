package com.example.pathfinder2021ch.service;

import com.example.pathfinder2021ch.domain.entity.UserEntity;
import com.example.pathfinder2021ch.domain.entity.enums.LevelUserEnum;
import com.example.pathfinder2021ch.domain.serviceDto.UserServiceModel;
import com.example.pathfinder2021ch.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    private  final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
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
}
