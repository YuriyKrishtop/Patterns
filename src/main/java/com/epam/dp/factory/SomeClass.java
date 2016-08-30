package com.epam.dp.factory;

/**
 * @author Ivan_Zhuravel
 */
@Component("SomeClass")
public class SomeClass {

    @InjectRandomInt
    private int intVal;

    private String test = "test";

    public String getTest() {
        return test;
    }

    public void setIntVal(int intVal) {
        this.intVal = intVal;
    }

    public int getIntVal() {
        return intVal;
    }

    @Override
    public String toString() {
        return "SomeClass{" +
                "intVal=" + intVal +
                ", test='" + test + '\'' +
                '}';
    }
}
