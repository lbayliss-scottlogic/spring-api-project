package com.scottlogic.grad_training.friendface.filter;

import com.scottlogic.UserPost;
import com.scottlogic.grad_training.friendface.User;

import java.util.List;

public interface Filter {
    List<User> filter(List<User> inputList);
}
