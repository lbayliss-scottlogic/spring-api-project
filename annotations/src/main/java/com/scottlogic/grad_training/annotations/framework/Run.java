package com.scottlogic.grad_training.annotations.framework;

import com.scottlogic.grad_training.annotations.Component;
import com.scottlogic.grad_training.annotations.Scheduled;
import org.reflections.Reflections;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Run {
    public static void main (String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        final Reflections reflections = new Reflections("com.scottlogic.grad_training.annotations.product", new TypeAnnotationsScanner());
        final Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(Component.class, true);

        for (Class<?> annotatedClass : annotatedClasses) {

            final Constructor<?> constructor = annotatedClass.getDeclaredConstructor();
            final Object component = constructor.newInstance();

            for (Method method : annotatedClass.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Scheduled.class)) {
                    Runnable runTask = () -> {
                        try {
                            method.invoke(component);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    };

                    final int timeout = method.getDeclaredAnnotation(Scheduled.class).timeout();
                    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
                    executor.scheduleAtFixedRate(runTask, 0, timeout, TimeUnit.MILLISECONDS);
                }
            }
        }

    }
}
