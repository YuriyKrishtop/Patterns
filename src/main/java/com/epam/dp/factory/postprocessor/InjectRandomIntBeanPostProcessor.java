package com.epam.dp.factory.postprocessor;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by Iurii_Kryshtop on 8/30/2016.
 */
public class InjectRandomIntBeanPostProcessor implements BeanPostProcessor {

    private static int createRandomInt() {
        return new Random().nextInt();
    }

    @Override
    public Object postProcessorOperation(Object obj) {
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectRandomInt.class)) {
                trySetRandomIntToField(obj, field);
            }
        }
        return obj;
    }

    private void trySetRandomIntToField(Object obj, Field field) {
        try {
            field.setAccessible(true);
            field.set(obj, createRandomInt());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}
