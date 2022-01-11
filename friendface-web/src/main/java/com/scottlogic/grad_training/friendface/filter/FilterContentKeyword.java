package com.scottlogic.grad_training.friendface.filter;

import com.scottlogic.UserPost;
import com.scottlogic.grad_training.friendface.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class FilterContentKeyword implements Filter {

    private String filterCriteria;

    public FilterContentKeyword(String filterBy) {
        filterCriteria = filterBy;
    }

    @Override
    public List<User> filter(List<User> inputList) {
        if (inputList == null) {
            return Arrays.asList();
        }
        List<User> outputList = new ArrayList<>(inputList);
        System.out.println(filterCriteria);
        return outputList.stream()
                .filter(a -> a.getContent().toLowerCase().contains(filterCriteria))
                .collect(Collectors.toList());
    }
}
