package com.epam.dp.factory;

import java.util.Collection;

/**
 * Created by Iurii_Kryshtop on 8/30/2016.
 */
public interface BeanPostProcessor {
   Collection<Object> postProcessorOperation(Collection<Object> col);
}
