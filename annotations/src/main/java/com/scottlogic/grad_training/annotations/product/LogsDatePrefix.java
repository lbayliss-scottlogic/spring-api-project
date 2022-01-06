package com.scottlogic.grad_training.annotations.product;

import com.scottlogic.grad_training.annotations.Component;
import com.scottlogic.grad_training.annotations.Logger;

import java.time.LocalDateTime;

@Component
public class LogsDatePrefix implements Logger {

    @Override
    public void log(String message) {
        System.out.println(LocalDateTime.now() + " " + message);
    }
}
