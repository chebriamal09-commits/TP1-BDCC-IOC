package net.amal.framework.context;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import net.amal.framework.injector.DependencyInjector;
import net.amal.framework.xml.BeanConfig;
import net.amal.framework.xml.BeansConfig;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class XmlApplicationContext {

    private final Map<String, Object> beans = new HashMap<>();

    public XmlApplicationContext(String xmlPath) {
        try {
            JAXBContext context = JAXBContext.newInstance(BeansConfig.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            BeansConfig config = (BeansConfig) unmarshaller.unmarshal(new File(xmlPath));

            for (BeanConfig beanConfig : config.getBeans()) {
                Class<?> clazz = Class.forName(beanConfig.getClassName());
                Object object = clazz.getDeclaredConstructor().newInstance();
                beans.put(beanConfig.getId(), object);
            }

            DependencyInjector injector = new DependencyInjector(beans);
            injector.injectDependencies();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Object getBean(String id) {
        return beans.get(id);
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