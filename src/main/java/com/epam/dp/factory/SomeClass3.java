package com.epam.dp.factory;

/**
 * Created by Iurii_Kryshtop on 8/30/2016.
 */
@Component("SomeClass3")
public class SomeClass3 {

    @InjectRandomInt
    private int intVal;

    private int intVal2;

    private String test = "test";

    @Override
    public String toString() {
        return "SomeClass3{" +
                "intVal2=" + intVal +
                ", intVal3=" + intVal2 +
                ", test='" + test + '\'' +
                '}';
    }
}
