package com.scottlogic.grad_training.friendface;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getPostsFromDB() {
        return userRepository.findAll();
    }

    @GetMapping("/getUserPosts")
    public List<User> getUserPosts() {
        return getPostsFromDB();
    }

    @PostMapping("/createUserPost")
    public void createUserPost(@RequestBody User userPost) {
        userRepository.save(userPost);
    }
}