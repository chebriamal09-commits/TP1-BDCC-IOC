package net.amal.framework.context;

import net.amal.framework.injector.DependencyInjector;
import net.amal.framework.scanner.ClassScanner;

import java.util.HashMap;
import java.util.Map;

public class AnnotationApplicationContext {

    private final Map<String, Object> beans = new HashMap<>();

    public AnnotationApplicationContext(String packageName) {
        try {
            ClassScanner scanner = new ClassScanner();
            scanner.scan(packageName).forEach(clazz -> {
                try {
                    Object object = clazz.getDeclaredConstructor().newInstance();
                    beans.put(clazz.getSimpleName(), object);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });

            DependencyInjector injector = new DependencyInjector(beans);
            injector.injectDependencies();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T getBean(Class<T> clazz) {
        for (Object bean : beans.values()) {
            if (clazz.isInstance(bean)) {
                return clazz.cast(bean);
            }
        }
        return null;
    }
}