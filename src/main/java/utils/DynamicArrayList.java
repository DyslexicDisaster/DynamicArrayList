package utils;

/**
 *
 * @author michelle
 */
public class DynamicArrayList {
    private String [] data;
    private int numElements;
    private static int capacity = 10;

    public DynamicArrayList() {
        data = new String[capacity];
        numElements = 0;
    }


}
