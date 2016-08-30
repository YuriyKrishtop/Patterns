package com.epam.dp.factory;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Random;

/**
 * Created by Iurii_Kryshtop on 8/30/2016.
 */
public class InjectRandomIntBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Collection<Object> postProcessorOperation(Collection<Object> col) {
        for (Object obj : col) {
            for(Field field  : obj.getClass().getDeclaredFields())
            {
                if (field.isAnnotationPresent(InjectRandomInt.class))
                {
                    field.setAccessible(true);
                    trySetRandomIntToField(obj, field);
                }
            }
        }
        return col;
    }

    private void trySetRandomIntToField(Object obj, Field field){
        Random rn = new Random();
        int max = 100000000;
        int min = 1;
        int n = max - min;
        int i = rn.nextInt() % n;
        try {
            field.set(obj, min + i);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}
