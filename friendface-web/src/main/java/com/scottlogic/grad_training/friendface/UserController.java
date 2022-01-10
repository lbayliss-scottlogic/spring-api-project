package com.scottlogic.grad_training.friendface;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserRepository userRepository;
    private final UserPostService userPostService;

    public UserController(UserRepository userRepository, UserPostService userPostService) {
        this.userRepository = userRepository;
        this.userPostService = userPostService;
    }

    @GetMapping("/getUserPosts")
    public List<User> getUserPosts() {
        return userRepository.findAll();
    }

    @PostMapping("/createUserPost")
    public void createUserPost(@RequestBody User user) {
        userRepository.save(user);
    }

    @GetMapping("/sort/authorUp")
    public void getPostsSortedAuthorUp() {

    }
}