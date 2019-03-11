package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {

    private final MyComparator comp;
    private int size;

    public SortDecorator(SmartArray smartArray, MyComparator comp) {
        super(smartArray);
        this.comp = comp;
        this.smartArray = smartArray;
    }

    @Override
    public Object[] toArray() {
        return modify();
    }

    @Override
    public String operationDescription() {
        return "Sort Decorator";
    }

    @Override
    public int size() {
        return size;
    }

    private Object[] modify() {
        Object[] output = smartArray.toArray();
        Arrays.sort(output, comp);
        size = output.length;
        return output;
    }
}

