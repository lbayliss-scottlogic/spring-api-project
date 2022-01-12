package com.scottlogic.grad_training.friendface;

import com.scottlogic.grad_training.friendface.filter.FilterContentKeyword;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPostFilterService {
    public List<User> filterPostsContentByKeyword(List<User> userPosts, String filterCriteria) {
        System.out.println("filter criteria: " + filterCriteria);
        if (filterCriteria.isEmpty()) {
            System.out.println("returning user posts");
            return userPosts;
        }
        FilterContentKeyword filterContentKeyword = new FilterContentKeyword(filterCriteria);
        return filterContentKeyword.filter(userPosts);
    }
}
