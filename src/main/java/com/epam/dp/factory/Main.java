package com.epam.dp.factory;

import java.util.Collection;

/**
 * @author Ivan_Zhuravel
 */
public class Main {

    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory();
        ApplicationContext applicationContext = new ApplicationContext(beanFactory);
        Collection<Object> col = applicationContext.getInjectRandomIntIntoBeans();
        for (Object obj : col) {
            System.out.println(obj);
        }
    }
}
