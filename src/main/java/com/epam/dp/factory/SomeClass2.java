package com.epam.dp.factory;

/**
 * Created by Iurii_Kryshtop on 8/30/2016.
 */
@Component("SomeClass2")
public class SomeClass2 {

    @InjectRandomInt
    private int intVal2;

    @InjectRandomInt
    private int intVal3;

    private String test = "test";

    @Override
    public String toString() {
        return "SomeClass2{" +
                "intVal2=" + intVal2 +
                ", intVal3=" + intVal3 +
                ", test='" + test + '\'' +
                '}';
    }
}
