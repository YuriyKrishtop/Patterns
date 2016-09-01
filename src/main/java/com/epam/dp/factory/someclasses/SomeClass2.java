package com.epam.dp.factory.someclasses;

import com.epam.dp.factory.postprocessor.InjectRandomInt;

/**
 * Created by Iurii_Kryshtop on 8/30/2016.
 */
@Component("SomeClass2")
public class SomeClass2 {

    @InjectRandomInt
    private int intVal;
    @InjectRandomInt
    private int intVal2;
    private String test = "test";

    @Override
    public String toString() {
        return "SomeClass2{" +
                "intVal=" + intVal +
                ", intVal2=" + intVal2 +
                ", test='" + test + '\'' +
                '}';
    }
}
