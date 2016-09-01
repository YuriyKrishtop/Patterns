package com.epam.dp.factory;

/**
 * @author Ivan_Zhuravel
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ApplicationContext(new BeanFactory());
        System.out.println(applicationContext.getBean("SomeClass"));
        System.out.println(applicationContext.getBean("SomeClass2"));
        System.out.println(applicationContext.getBean("SomeClass3"));
    }
}
