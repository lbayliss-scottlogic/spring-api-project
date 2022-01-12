package com.scottlogic.grad_training.friendface;

import com.scottlogic.SortOrder;
import com.scottlogic.grad_training.friendface.sort.SortAuthor;
import com.scottlogic.grad_training.friendface.sort.SortDate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPostSortService {

    public List<User> sortByAuthorAscending(List<User> posts) {
        SortAuthor sortAuthorAsc = new SortAuthor(SortOrder.ASC);
        return sortAuthorAsc.sort(posts);
    }

    public List<User> sortByAuthorDescending(List<User> posts) {
        SortAuthor sortAuthorDesc = new SortAuthor(SortOrder.DESC);
        return sortAuthorDesc.sort(posts);
    }

    public List<User> sortByDateAscending(List<User> posts) {
        SortDate sortDate = new SortDate(SortOrder.ASC);
        return sortDate.sort(posts);
    }

    public List<User> sortByDateDescending(List<User> posts) {
        SortDate sortDate = new SortDate(SortOrder.DESC);
        return sortDate.sort(posts);
    }
}
