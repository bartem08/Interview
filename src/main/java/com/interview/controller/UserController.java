package com.interview.controller;

import com.interview.model.projection.Title;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController extends AbstractController {

    @RequestMapping("/me")
    public Title getCurrentUserInfo() {

        return buildTitle(getCurrentUser());
    }
}
