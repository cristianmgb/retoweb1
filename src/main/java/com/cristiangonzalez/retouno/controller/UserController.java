package com.cristiangonzalez.retouno.controller;

import com.cristiangonzalez.retouno.model.User;
import com.cristiangonzalez.retouno.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;
    
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User newUser(@RequestBody User user) {
        return userService.save(user);
    }
    
    @GetMapping("/{email}/{password}")
    public User authUser(@PathVariable("email") String email, @PathVariable("password") String password) {

        return userService.authUser(email, password);
    }
    @GetMapping("/{email}")
    public boolean validateEmail(@PathVariable("email") String email) {
        return userService.validateteEmail(email);
    }

}
