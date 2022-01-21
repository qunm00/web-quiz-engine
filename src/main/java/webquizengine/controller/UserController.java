package webquizengine.controller;

import webquizengine.businesslayer.User;
import webquizengine.businesslayer.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/api/register")
    public void register(@Valid @RequestBody User user) {
        this.userService.save(user);
    }
}