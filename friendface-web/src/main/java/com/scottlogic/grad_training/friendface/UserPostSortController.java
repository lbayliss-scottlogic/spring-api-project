package com.scottlogic.grad_training.friendface;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserPostSortController {

    private final UserRepository userRepository;
    private final UserPostSortService userPostSortService;

    public UserPostSortController(UserRepository userRepository, UserPostSortService userPostService) {
        this.userRepository = userRepository;
        this.userPostSortService = userPostService;
    }

    public List<User> getPostsFromDB() {
        return userRepository.findAll();
    }

    @GetMapping("/sort/authorAscending")
    public List<User> getPostsSortedAuthorAscending() {
        return userPostSortService.sortByAuthorAscending(getPostsFromDB());
    }

    @GetMapping("/sort/authorDescending")
    public List<User> getPostsSortedAuthorDescending() {
        return userPostSortService.sortByAuthorDescending(getPostsFromDB());
    }

    @GetMapping("/sort/dateAscending")
    public List<User> getPostsSortedDateAscending() {
        return userPostSortService.sortByDateAscending(getPostsFromDB());
    }

    @GetMapping("/sort/dateDescending")
    public List<User> getPostsSortedDateDescending() {
        return userPostSortService.sortByDateDescending(getPostsFromDB());
    }
}