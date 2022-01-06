package com.scottlogic.grad_training.annotations;

import org.reflections.Reflections;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.util.Set;


@Deprecated
public class Main {
    public static void main (String[] args) {
        final Reflections reflections = new Reflections("com.scottlogic", new TypeAnnotationsScanner());
        final Set<Class<?>> deprecatedClasses = reflections.getTypesAnnotatedWith(Deprecated.class, true);
        System.out.printf("Deprecated classes: %s\n", deprecatedClasses);

        final Set<Class<?>> discoveredClass = reflections.getTypesAnnotatedWith(Author.class, true);
        for (Class<?> classes : discoveredClass) {
            final Author annotation = classes.getAnnotation(Author.class);
            System.out.println("Author names: " + annotation.author());
        }
    }
}