package com.scottlogic.grad_training.annotations.product;

import com.scottlogic.grad_training.annotations.Component;
import com.scottlogic.grad_training.annotations.Scheduled;

@Component
public class Task {
    @Scheduled(timeout = 1000)
    public void run() {
        System.out.println("Hello1");
    }
}
