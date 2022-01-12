package com.scottlogic.grad_training.friendface;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserPostFilterController {

    private final UserRepository userRepository;
    private final UserPostFilterService userPostFilterService;

    public UserPostFilterController(UserRepository userRepository, UserPostFilterService userPostFilterService) {
        this.userRepository = userRepository;
        this.userPostFilterService = userPostFilterService;
    }

    public List<User> getPostsFromDB() {
        return userRepository.findAll();
    }

    @PostMapping("/filter/content")
    public List<User> filterUserPostsContentByKeyword(@RequestBody(required = false) String keyword) {
        if (keyword == null) {
            return getPostsFromDB();
        }
        return userPostFilterService.filterPostsContentByKeyword(getPostsFromDB(), keyword);
    }
}