package com.interview.controller;

import com.interview.model.Response;
import com.interview.model.entity.User;
import com.interview.model.projection.Title;
import com.interview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/users")
public class UserController extends AbstractController {

    @Autowired
    private UserService userService;

    @RequestMapping("/me")
    public Title getCurrentUserInfo() {

        return buildTitle(getCurrentUser());
    }

    @Secured("ROLE_HR")
    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
    public Response createUser(@RequestBody User user) {

        userService.encodePassword(user);
        Optional<User> created = userService.create(user);

        if (!created.isPresent()) {
            return buildResponse(CONFLICT,
                    messageService.getMessage("not.create", "user.label"));
        }
        return buildResponse(CREATED,
                messageService.getMessage("success.create", "user.label"));
    }
}
