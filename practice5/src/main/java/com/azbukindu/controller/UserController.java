package com.azbukindu.controller;

import com.azbukindu.model.UserEntity;
import com.azbukindu.model.UserRequestModel;
import com.azbukindu.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<UserEntity> getUserById(@RequestParam int id) {
        UserEntity user = userService.getUser(id);

        return ResponseEntity.ok(user);
    }

    @PostMapping("/get")
    public ResponseEntity<UserEntity> getUserByJson(@RequestBody UserRequestModel userRequestModel) {
        UserEntity user = userService.getUser(userRequestModel.getId());

        return ResponseEntity.ok(user);
    }

    @PostMapping("/add")
    public ResponseEntity<UserEntity> addUser(@RequestBody UserRequestModel userRequestModel) {
        UserEntity user = userService.addUser(userRequestModel);

        return ResponseEntity.ok(user);
    }
}
