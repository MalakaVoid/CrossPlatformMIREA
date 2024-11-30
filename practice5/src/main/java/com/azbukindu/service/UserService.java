package com.azbukindu.service;

import com.azbukindu.model.UserEntity;
import com.azbukindu.model.UserRequestModel;

public interface UserService {

    public UserEntity getUser(int id);
    public UserEntity addUser(UserRequestModel userRequestModel);
}
