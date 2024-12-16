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
    public ResponseEntity<UserEntity> retrieveUser(@RequestParam(value = "id", required = false) Integer userId,
                                                   @RequestBody(required = false) UserRequestModel request) {
        if (userId == null && request == null) {
            return ResponseEntity.badRequest().build();
        }

        int finalUserId = (userId != null) ? userId : request.getId();
        UserEntity user = userService.getUser(finalUserId);

        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserEntity> addUser(@RequestBody UserRequestModel userRequestModel) {
        UserEntity user = userService.addUser(userRequestModel);

        return ResponseEntity.ok(user);
    }
}
