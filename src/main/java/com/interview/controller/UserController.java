package com.interview.controller;

import com.interview.model.entity.User;
import com.interview.model.projection.Name;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController extends AbstractController {

    @RequestMapping("/me")
    public Name getCurrentUserInfo() {

        User user = getCurrentUser();
        return Name.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}
