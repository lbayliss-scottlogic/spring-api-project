package com.scottlogic.grad_training.friendface.sort;

import com.scottlogic.SortOrder;
import com.scottlogic.grad_training.friendface.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortAuthor implements Sort {

    private SortOrder sortOrder;

    public SortAuthor(SortOrder orderToSort) {
        sortOrder = orderToSort;
    }

    @Override
    public List<User> sort(List<User> inputList) {
        if (inputList == null) {
            return Arrays.asList();
        }
        if (SortOrder.ASC.equals(sortOrder)) {
            Collections.sort(inputList, Comparator.comparing(User::getAuthor));
        }
        else {
            Collections.sort(inputList, Comparator.comparing(User::getAuthor).reversed());
        }
        return inputList;
    }
}
