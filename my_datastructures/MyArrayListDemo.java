package my_datastructures;

class MyArrayList {
    // ===== members
    private int cap; // capacity of the array list
    private int len; // actual length of the array list
    private int[] elems; // container keeping the elements

    // ===== functions
    public MyArrayList() {
        cap = len = 0;
        elems = null;
    }

    public MyArrayList(int initialCapacity) {
        cap = initialCapacity;
        len = 0;
        elems = new int[cap];
    }

    public MyArrayList(int[] elements) {
        if (elements == null) {
            cap = len = 0;
            elems = null;
            return;
        }
        cap = len = elements.length;
        elems = new int[cap];
        for (int i = 0; i < len; i++)
            elems[i] = elements[i];
    }
}

public class MyArrayListDemo {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
