package com.epam.dp.factory;

import com.epam.dp.factory.postprocessor.BeanPostProcessor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Iurii on 29.08.2016.
 */
public class ApplicationContext {
    private BeanFactory beanFactory;

    public ApplicationContext(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
        doPostProcessorOperations();
    }

    public Object getBean(String id) {
        return beanFactory.getBean(id);
    }

    private void doPostProcessorOperations() {
        for (Object bean : beanFactory.getBeans()) {
            for (BeanPostProcessor bpp : beanFactory.getPostProcessBeans()) {
                tryDoPostProcessorOperations(bean, bpp);
            }
        }
    }

    private void tryDoPostProcessorOperations(Object bean, BeanPostProcessor bpp) {
        try {
            Method[] postProcessorMethods = BeanPostProcessor.class.getDeclaredMethods();
            for (Method method : postProcessorMethods) {
                method.invoke(bpp, bean);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
