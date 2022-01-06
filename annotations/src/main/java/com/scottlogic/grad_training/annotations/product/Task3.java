package com.scottlogic.grad_training.annotations.product;

import com.scottlogic.grad_training.annotations.Component;
import com.scottlogic.grad_training.annotations.Scheduled;

@Component
public class Task3 {
    @Scheduled(timeout = 5000)
    public void run () {
        System.out.println("Hello3");
    }
}