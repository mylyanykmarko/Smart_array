package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {


    private Object[] MyArray;

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.MyArray, MyArray.length);
    }

    @Override
    public String operationDescription() {
        return "BaseArray";
    }

    @Override
    public int size() {
        return this.MyArray.length;
    }

    public BaseArray(Object[] myArray) {
        this.MyArray = myArray;
    }

}