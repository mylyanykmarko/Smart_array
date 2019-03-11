package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private final MyFunction func;
    private int size;

    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        this.func = func;
    }

    @Override
    public Object[] toArray() {

        return modify();
    }

    @Override
    public String operationDescription() {
        return "MapDecorator";
    }

    @Override
    public int size() {
        return size;
    }

    private Object[] modify() {
        Object[] arr = smartArray.toArray();
        for (int x = 0; x < arr.length; x++) {
            arr[x] = this.func.apply(arr[x]);
        }
        size = arr.length;
        return arr;
    }
}
