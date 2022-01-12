package com.scottlogic.grad_training.friendface.sort;

import com.scottlogic.SortOrder;
import com.scottlogic.UserPost;
import com.scottlogic.grad_training.friendface.User;

import java.util.List;

public interface Sort {
    List<User> sort(List<User> inputList);
}