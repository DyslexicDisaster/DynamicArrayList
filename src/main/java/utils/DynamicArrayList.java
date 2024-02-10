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

    public int size() {
        return numElements;
    }

    public String get(int pos) {
        if (pos < 0 || pos >= numElements) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        return data[pos];
    }

    public int indexOf(String element) {
        for (int i = 0; i < numElements; i++) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
    //in order to create an add method we must first create a grow method in case the array is full
    // or use arraycopy, but I went with the grow array
    private void grow(){
        //could have created an expansion facter variable but i just decided to use the capacity variable
        String [] tempArray = new String[data.length + capacity];
        for(int i = 0; i < data.length; i++){
            tempArray[i] = data[i];
        }

        data = tempArray;
    }
    public boolean add(String element) {
        if (numElements == data.length) {
            grow();
        }
        data[numElements++] = element;
        return true;
    }
}
