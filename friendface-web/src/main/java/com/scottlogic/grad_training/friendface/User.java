package com.scottlogic.grad_training.friendface;

import com.scottlogic.UserPost;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="userposts")
public class User {
    @Id
    @Column
    private int id;

    @NotNull(message = "Author cannot be null")
    private String author;

    private String content;

    @Min(value = 0, message = "Likes should not be less than 0")
    private int likes;

    private String date;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

//    public List<UserPost> toUserPostList(List<User> users) {
//        List<UserPost> userPosts = new ArrayList<>();
//        for (User user : users) {
//
//        }
//    }
}