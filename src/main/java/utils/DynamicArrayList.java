package utils;

/**
 *
 * @author michelle
 */
public class DynamicArrayList {
    private String [] data;
    private int numElements;
    private static final int capacity = 10;

    //Core methods

    /**
     *  Constructs a DynamicArrayList with the standard initial capacity.
     */
    public DynamicArrayList() {
        data = new String[capacity];
        numElements = 0;
    }

    /**
     * Returns the number of elements currently stored in the list.
     * @return The number of elements in the list.
     */
    public int size() {
        return numElements;
    }

    /**
     * Retrieves the element at the specified position in the list.
     * @param pos The position of the element to retrieve.
     * @return The element at the specified position.
     */
    public String get(int pos) {
        if (pos < 0 || pos >= numElements) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        return data[pos];
    }

    /**
     * Returns the position of the specified string in the Array.
     * @param element The string to search for.
     * @return The position of the string in the array, or -1 if not found.
     */
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

    /**
     * Increases the capacity of the internal array when necessary.
     */
    private void grow(){
        //could have created an expansion facter variable but i just decided to use the capacity variable
        String [] tempArray = new String[numElements + capacity];
        for(int i = 0; i < numElements; i++){
            tempArray[i] = data[i];
        }

        data = tempArray;
    }

    /**
     * Adds a string to the end of the list.
     * @param element The string to add.
     * @return true if the string was added successfully, false otherwise.
     */
    public boolean add(String element) {
        if (numElements == data.length) {
            grow();
        }
        data[numElements++] = element;
        return true;
    }
    /**
     * Checks if the list is empty.
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return numElements == 0;
    }

    //unique methods

    public DynamicArrayList(String[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Array is null");
        }
        /*if (arr.length > capacity) {
            data = new String[arr.length];
        } else {
            data = new String[capacity];
        }*/
        data = new String[capacity];
        numElements = 0;

        /*while (arr.length > capacity) {
            grow();
        }*/
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                throw new IllegalArgumentException("Elements in the array can't be null");
            }
            //data[numElements++] = arr[i];
            add(arr[i]);
        }
    }

    public String set(int pos, String newData) {
        if (pos < 0 || pos >= numElements) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        String og = data[pos];
        data[pos] = newData;
        return og;
    }

    public DynamicArrayList clone() {
        DynamicArrayList cloned = new DynamicArrayList();
        for (int i = 0; i < numElements; i++) {
            cloned.add(data[i]);
        }
        return cloned;
    }
}
