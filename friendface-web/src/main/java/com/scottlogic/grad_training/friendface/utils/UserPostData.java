package com.scottlogic.grad_training.friendface.utils;

import com.scottlogic.UserPost;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;

public class UserPostData {
    public static List<UserPost> getUserPosts() {
        UserPost userPost1 = new UserPost("Mick Jagger",
                OffsetDateTime.of(2020, 1, 3, 7, 12, 3, 0, ZoneOffset.UTC).toString(),
                "You got moves like me?", 2, 1);

        UserPost userPost2 = new UserPost("Matt Damon",
                OffsetDateTime.of(2020, 1, 3, 8, 53, 34, 0, ZoneOffset.UTC).toString(),
                "How you like them apples?!", 1, 2);

        UserPost userPost3 = new UserPost("Jane Austin Smith",
                OffsetDateTime.of(2020, 3, 12, 13, 22, 12, 0, ZoneOffset.UTC).toString(),
                "An example of a post \nwith lines breaks.", 3, 3);

        UserPost userPost4 = new UserPost("Steve",
                OffsetDateTime.of(1997, 11, 14, 10, 50, 1, 0, ZoneOffset.UTC).toString(),
                "My name is Jeoff", 9, 4);

        UserPost userPost5 = new UserPost("This funky-name",
                OffsetDateTime.of(2001, 1, 1, 1, 1, 1, 1, ZoneOffset.UTC).toString(),
                "funky funk funk", 10, 5);

        return Arrays.asList(userPost1, userPost2, userPost3, userPost4, userPost5);
    }
}
