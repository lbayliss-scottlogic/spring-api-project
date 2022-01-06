package com.scottlogic.grad_training.annotations.framework;

import com.scottlogic.grad_training.annotations.Component;
import com.scottlogic.grad_training.annotations.Logger;
import com.scottlogic.grad_training.annotations.RunOnce;
import org.reflections.Reflections;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RunTasks {
    public static void main (String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        final Map<Class<?>, Object> components = new HashMap<>();

        final Reflections reflections = new Reflections("com.scottlogic.grad_training.annotations.product", new TypeAnnotationsScanner());
        final Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(Component.class, true);
        for (Class<?> annotatedClass : annotatedClasses) {
            // Construct instances of each class
            try {
                final Constructor<?> constructor = annotatedClass.getDeclaredConstructor();
                final Object component = constructor.newInstance();
                if (Logger.class.isAssignableFrom(annotatedClass)) {
                    components.put(Logger.class, component);
                }
            }
            catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }

        for (Class<?> annotatedClass : annotatedClasses) {
            System.out.println("here1");
            try {
                final Constructor<?> constructor = annotatedClass.getDeclaredConstructor(Logger.class);
                System.out.println("here2");
                final Logger loggerImplementation = (Logger) components.get(Logger.class);
                System.out.println("here3");
                final Object component = constructor.newInstance(loggerImplementation);
                System.out.println("here4");
                for (Method method : annotatedClass.getDeclaredMethods()) {
                    System.out.println(method);
                    method.invoke(component);
                }
            }
            catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
    }
}
