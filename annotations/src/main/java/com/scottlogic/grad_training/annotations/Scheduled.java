package com.scottlogic.grad_training.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Scheduled {
    int timeout() default 10000;
}
