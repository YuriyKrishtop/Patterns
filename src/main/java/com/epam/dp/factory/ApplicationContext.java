package com.epam.dp.factory;

import java.util.Collection;
import java.util.Set;

/**
 * Created by Iurii on 29.08.2016.
 */
public class ApplicationContext {
    private BeanFactory beanFactory;

    public ApplicationContext(BeanFactory beanFactory){
        this.beanFactory = beanFactory;
    }

    public Object getBean(String id){
        return beanFactory.getBean(id);
    }

    public Collection<Object> getBeans(){
        return beanFactory.getBeans();
    }

    public Collection<Object> getInjectRandomIntIntoBeans(){
        return new InjectRandomIntBeanPostProcessor().postProcessorOperation(getBeans());
    }

    public Set<Object> getPostProcessBeans() {
        return beanFactory.getPostProcessBeans();
    }

}
