package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate pr;
    private int size;

    public FilterDecorator(SmartArray smartArray, MyPredicate pr) {
        super(smartArray);
        this.pr = pr;
    }

    @Override
    public Object[] toArray() {
        return modify();
    }

    @Override
    public String operationDescription() {
        return "Filter Decorator";
    }

    @Override
    public int size() {
        return size;
    }


    private Object[] modify() {

        Object[] arr = smartArray.toArray();
        int sum = arr.length;
        for (int x = 0; x < arr.length; x++) {
            if (!pr.test(arr[x])) {
                sum--;
            }
        }
        int index = 0;
        Object[] output = new Object[sum];
        for (Object anArr : arr) {
            if (pr.test(anArr)) {
                output[index] = anArr;
                index++;
            }
        }
        size = output.length;
        return output;
    }
}



