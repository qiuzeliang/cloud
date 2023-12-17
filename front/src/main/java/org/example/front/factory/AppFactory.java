package org.example.front.factory;

import org.springframework.context.ApplicationContext;

public class AppFactory {
    private static final AppFactory factory = new AppFactory();
    private ApplicationContext context;

    public static void init(ApplicationContext context) {
        factory.context = context;
    }

    public static <T> T getBean(Class<T> clazz) {
        return factory.context.getBean(clazz);
    }
}
