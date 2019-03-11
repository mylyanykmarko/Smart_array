package ua.edu.ucu.smartarr;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    private int size;

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }


    @Override
    public Object[] toArray() {
        return modify();
    }

    @Override
    public String operationDescription() {
        return "Disting decorator";
    }

    @Override
    public int size() {
        return size;
    }

    private Object[] modify() {
        Object[] input = smartArray.toArray();
        Object[] arr = input;
        int sum = arr.length;
        for (int x = 0; x < arr.length; x++) {
            for (int z = x; z < arr.length; z++) {
                if (arr[x].toString().equals(arr[z].toString()) && x != z ) {
                    arr[z] = "EMPTY";
                    sum--;
                }
            }
        }
        int nwlrngth = -1;
        Object[] output = new Object[sum];
        for (int q = 0; q < arr.length; q++) {
            if (!arr[q].toString().equals("EMPTY")) {
                nwlrngth++;
                output[nwlrngth] = arr[q];

            }
        }
        size = output.length;
        return output;
    }
}