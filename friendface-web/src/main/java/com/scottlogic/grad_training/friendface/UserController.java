package com.scottlogic.grad_training.friendface;

import com.scottlogic.UserPost;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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

    @GetMapping("/sort/authorAscending")
    public List<User> getPostsSortedAuthorAscending() {
        return userPostService.sortByAuthorAscending(getPostsFromDB());
    }

    @GetMapping("/sort/authorDescending")
    public List<User> getPostsSortedAuthorDescending() {
        return userPostService.sortByAuthorDescending(getPostsFromDB());
    }

    @GetMapping("/sort/dateAscending")
    public List<User> getPostsSortedDateAscending() {
        return userPostService.sortByDateAscending(getPostsFromDB());
    }

    @GetMapping("/sort/dateDescending")
    public List<User> getPostsSortedDateDescending() {
        return userPostService.sortByDateDescending(getPostsFromDB());
    }
}