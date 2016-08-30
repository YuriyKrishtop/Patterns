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
        System.out.println(applicationContext.getPostProcessBeans());
        System.out.println(applicationContext.getBean("SomeClass"));
        System.out.println(applicationContext.getBean("SomeClass2"));
        System.out.println(applicationContext.getBean("SomeClass3"));
    }
}
