package com.scottlogic.grad_training.annotations.product;

import com.scottlogic.grad_training.annotations.Component;
import com.scottlogic.grad_training.annotations.Logger;
import com.scottlogic.grad_training.annotations.RunOnce;

@Component
public class TaskWithDependencies {
    private final Logger logger;

    public TaskWithDependencies(Logger logger) {
        this.logger = logger;
    }

    @RunOnce
    public void sayHello() {
        logger.log("Hello!");
    }
}