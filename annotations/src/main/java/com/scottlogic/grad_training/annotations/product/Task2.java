package com.scottlogic.grad_training.annotations.product;

import com.scottlogic.grad_training.annotations.Component;
import com.scottlogic.grad_training.annotations.Scheduled;

@Component
public class Task2 {
    @Scheduled()
    public void run () {
        System.out.println("Hello2");
    }
}
