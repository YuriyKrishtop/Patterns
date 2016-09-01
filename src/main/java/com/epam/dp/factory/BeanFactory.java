package com.epam.dp.factory;

import com.epam.dp.factory.someclasses.Component;
import com.epam.dp.factory.postprocessor.BeanPostProcessor;
import org.reflections.Reflections;

import java.util.*;

/**
 * @author Ivan_Zhuravel
 */
public class BeanFactory {

    private Reflections reflections = new Reflections("com.epam.dp.factory");
    private Map<String, Object> beans = new HashMap<>();
    private Set<BeanPostProcessor> postProcessBeans = new HashSet<>();

    {
        Set<Class<? extends BeanPostProcessor>> annotatedPostProcBeans = reflections.getSubTypesOf(BeanPostProcessor.class);
        for (Class<? extends BeanPostProcessor> clazz : annotatedPostProcBeans) {
            tryAddPostProcessBean(clazz);
        }
        Set<Class<?>> annotatedWith = reflections.getTypesAnnotatedWith(Component.class);
        for (Class<?> clazz : annotatedWith) {
            tryAddToListeners(clazz);
        }
    }

    public Set<BeanPostProcessor> getPostProcessBeans() {
        return postProcessBeans;
    }

    public Collection<Object> getBeans() {
        return beans.values();
    }

    public Object getBean(final String id) {
        return beans.get(id);
    }

    private void tryAddPostProcessBean(Class<? extends BeanPostProcessor> clazz) {
        try {
            postProcessBeans.add(clazz.newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void tryAddToListeners(Class<?> clazz) {
        try {
            Component annotation = clazz.getAnnotation(Component.class);
            beans.put(annotation.value(), clazz.newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}