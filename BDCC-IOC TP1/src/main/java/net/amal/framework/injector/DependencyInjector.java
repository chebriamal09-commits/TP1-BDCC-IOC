package net.amal.framework.injector;

import net.amal.framework.annotations.Inject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class DependencyInjector {

    private final Map<String, Object> beans;

    public DependencyInjector(Map<String, Object> beans) {
        this.beans = beans;
    }

    public void injectDependencies() {
        for (Object bean : beans.values()) {
            injectFields(bean);
            injectSetters(bean);
        }
    }

    private void injectFields(Object bean) {
        for (Field field : bean.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                try {
                    Object dependency = findBeanByType(field.getType());
                    field.setAccessible(true);
                    field.set(bean, dependency);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void injectSetters(Object bean) {
        for (Method method : bean.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Inject.class) && method.getParameterCount() == 1) {
                try {
                    Object dependency = findBeanByType(method.getParameterTypes()[0]);
                    method.setAccessible(true);
                    method.invoke(bean, dependency);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private Object findBeanByType(Class<?> type) {
        for (Object bean : beans.values()) {
            if (type.isInstance(bean)) {
                return bean;
            }
        }
        throw new RuntimeException("Aucun bean trouvé pour le type : " + type.getName());
    }
}