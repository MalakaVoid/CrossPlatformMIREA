package com.azbukindu.service;

import com.azbukindu.model.UserEntity;
import com.azbukindu.model.UserRequestModel;
import com.azbukindu.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserEntity getUser(int id) {
        return userRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public UserEntity addUser(UserRequestModel userRequestModel) {
        UserEntity user = new UserEntity();
        user.setFirstName(userRequestModel.getFirstName());
        user.setLastName(userRequestModel.getLastName());

        user.setEmail(userRequestModel.getEmail());
        user.setJob(userRequestModel.getJob());
        return userRepository.save(user);
    }
}
